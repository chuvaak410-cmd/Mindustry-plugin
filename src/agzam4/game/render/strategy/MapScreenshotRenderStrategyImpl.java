package agzam4.game.render.strategy;

import java.awt.Color;
import java.awt.image.BufferedImage;

import agzam4.game.Images;
import agzam4.game.render.registry.IMapColorPaletteRegistry;
import agzam4.game.render.registry.MapColorPaletteRegistry;
import arc.func.Boolf;
import arc.util.Log;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.gen.Player;
import mindustry.world.Tile;

/** Default {@link IMapScreenshotRenderStrategy}, mirroring the original {@code Images} logic exactly. */
public class MapScreenshotRenderStrategyImpl implements IMapScreenshotRenderStrategy {

	private final IMapColorPaletteRegistry registry = MapColorPaletteRegistry.instance();
	private final IScreenshotAnnotationRenderStrategy annotation = new ScreenshotAnnotationRenderStrategyImpl();

	@Override
	public BufferedImage screenshot(Player player) {
		if(player == null) return Images.placeholder;
		int dx = (int) (player.tileX() - Vars.world.width()/6);
		int dy = (int) (player.tileY() - Vars.world.height()/6);

		BufferedImage screen = screenshot(dx, dy, Vars.world.width()/3, Vars.world.height()/3, false);
		return screen;
	}

	@Override
	public BufferedImage screenshot(int sx, int sy, int w, int h, boolean single) {
		int[][] mapColors = registry.mapColors();
		if(mapColors == null) return Images.placeholder;
		BufferedImage screen = new BufferedImage(single ? w : w*3, single ? h : h*3, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < screen.getHeight(); y++) {
			for (int x = 0; x < screen.getWidth(); x++) {
				screen.setRGB(x, y, x | (y << 8));
			}
		}
		Log.info("screenshot (@;@) @x@", sx, sy, w, h);

		Boolf<Tile> hasBlock = t -> t != null && t.build != null;

		try {
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					Tile t = Vars.world.tile(sx+x, sy+h-y-1);
					if(t == null) continue;
					if(t.block() != null && t.block() != Blocks.air) {
						int size = t.block().size;
						int dx = t.x-t.centerX()+size/2 - 1 + (size%2);
						int dy = t.centerY()-t.y+size/2;
						int[] arr = mapColors[t.blockID()];
						if(single) {
							screen.setRGB(x, y, mapColors[t.blockID()][dx*3+1+dy*3*size + size]);
						} else {
							for (int py = 0; py < 3; py++) {
								for (int px = 0; px < 3; px++) {
									int index = dx*3+px + (dy*3+py)*size*3;
									if(index < 0 || index >= arr.length) continue;
									screen.setRGB(x*3+px, y*3+py, arr[index]);
								}
							}
						}
						continue;
					}
					if(single && (hasBlock.get(Vars.world.tile(x-1, h-y-1))
							|| hasBlock.get(Vars.world.tile(x+1, h-y-1))
							|| hasBlock.get(Vars.world.tile(x, h-y-2))
							|| hasBlock.get(Vars.world.tile(x, h-y)))) {
						screen.setRGB(x, y, Color.black.getRGB());
						continue;
					}
					if(t.floor() != null && t.floor() != Blocks.air) {
						if(single) {
							screen.setRGB(x, y, mapColors[t.floorID()][4]);
						} else {
							for (int py = 0; py < 3; py++) {
								for (int px = 0; px < 3; px++) {
									int rgba = mapColors[t.floorID()][px+py*3];
									screen.setRGB(x*3+px, y*3+py, rgba);
								}
							}
						}
					}
					if(t.overlay() != null && t.overlay() != Blocks.air) {
						if(single) {
							screen.setRGB(x, y, mapColors[t.overlayID()][4]);
						} else {
							for (int py = 0; py < 3; py++) {
								for (int px = 0; px < 3; px++) {
									int rgba = mapColors[t.overlayID()][px+py*3];
									if(!annotation.isTransparent(rgba)) screen.setRGB(x*3+px, y*3+py, rgba);
								}
							}
						}
						continue;
					}
				}
			}
		} catch (Exception e) {
			Log.err(e);
		}
		annotation.drawData(screen, single, sx, sy);
		return screen;
	}
}
