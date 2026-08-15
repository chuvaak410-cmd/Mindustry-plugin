package agzam4.game.render.registry;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import agzam4.game.MindustryGameRuntimeFacade;
import arc.math.geom.Point2;
import arc.util.Log;
import arc.util.Nullable;
import mindustry.Vars;

/**
 * Singleton default {@link IMapColorPaletteRegistry}. {@link #init()} is
 * the exact body of the original {@code Images.init()}, including the
 * {@code Log.info} call and exception handling, moved here verbatim.
 */
public final class MapColorPaletteRegistry implements IMapColorPaletteRegistry {

	private static final MapColorPaletteRegistry INSTANCE = new MapColorPaletteRegistry();

	private int[][] mapColors = null;

	private MapColorPaletteRegistry() {}

	public static MapColorPaletteRegistry instance() {
		return INSTANCE;
	}

	@Override
	public void init() {
		try {
			BufferedImage colors = ImageIO.read(MindustryGameRuntimeFacade.class.getResourceAsStream("/colors.png"));
			Log.info("file: @", colors);
			mapColors = new int[Vars.content.blocks().size][];
			Point2 id = new Point2(0,0);
	    	Vars.content.blocks().each(b -> {
	    		int index = id.x++;
				int size = b.size*3;
				mapColors[index] = new int[size*size];
				for (int i = 0; i < size*size; i++) {
					int rgb = colors.getRGB(id.y/9, id.y%9);
					id.y++;
					if(i == size*size/2) {
						Color col = new Color(rgb);
						b.mapColor.set(col.getRed()/255f, col.getGreen()/255f, col.getBlue()/255f);
						b.hasColor = true;
					}
					mapColors[index][i] = rgb;//b.mapColor.rgb888();
				}
	    	});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public @Nullable int[][] mapColors() {
		return mapColors;
	}
}
