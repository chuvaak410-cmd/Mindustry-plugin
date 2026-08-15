package agzam4.game.render.strategy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import mindustry.Vars;
import mindustry.gen.Groups;
import mindustry.graphics.Pal;
import mindustry.world.Tile;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.storage.CoreBlock;

/** Default {@link IScreenshotAnnotationRenderStrategy}, mirroring the original {@code Images} logic exactly. */
public class ScreenshotAnnotationRenderStrategyImpl implements IScreenshotAnnotationRenderStrategy {

	@Override
	public void drawData(BufferedImage screen, boolean single, int dx, int dy) {
		int scale = single ? 1 : 3;
		int sdx = -dx*scale;
		int sdy = -dy*scale;
		Graphics2D g = (Graphics2D) screen.getGraphics();
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < Groups.player.size(); i++) {
			var p = Groups.player.index(i);
			if(p.unit() != null) {
				for (int pl = 0; pl < p.unit().plans.size; pl++) {
					var plan = p.unit().plans.get(pl);
					g.setColor(plan.breaking ? Color.red : Color.yellow);
					g.drawLine(p.tileX()*scale+sdx, screen.getHeight()-(p.tileY()*scale+sdy),
							plan.x*scale+sdx, screen.getHeight()-(plan.y*scale+sdy));
				}
			}
			drawString(screen, g, p.plainName(), p.color, p.tileX()*scale+sdx, p.tileY()*scale+sdy);
		}
		for (int y = 0; y < Vars.world.width(); y++) {
			for (int x = 0; x < Vars.world.height(); x++) {
				Tile t = Vars.world.tile(x, y);
				if(t == null) continue;
				if(!t.isCenter()) continue;
				if(t.block() == null) continue;
				if(!t.block().hasBuilding()) continue;
				if(t.block() instanceof CoreBlock) {
					drawString(screen, g, t.block().localizedName, t.team().color, x*scale+sdx, y*scale+sdy);
				}
				if(t.block() instanceof LogicBlock) {
					drawString(screen, g, "P", Pal.logicOperations, x*scale+sdx, y*scale+sdy);
				}
			}
		}
		Groups.unit.each(un -> {
			g.setColor(new Color(un.team.color.rgb888()));
			if(!single) {
				if(!un.spawnedByCore) drawString(screen, g, un.type.name, un.team.color, un.tileX()*scale+sdx, un.tileY()*scale+sdy);
			}
			g.fillOval(un.tileX()*scale+sdx, screen.getHeight()-(un.tileY()*scale+sdy),4,4);
		});
		g.dispose();
	}

	@Override
	public void drawString(BufferedImage img, Graphics2D g, String text, arc.graphics.Color color, int x, int y) {
		g.setColor(Color.black);
		g.drawString(text, x - g.getFontMetrics().stringWidth(text)/2, (img.getHeight()-y-1)-5);
		g.setColor(new Color(color.rgb888()));
		g.drawString(text, x - g.getFontMetrics().stringWidth(text)/2-1, (img.getHeight()-y-1)-4);
	}

	@Override
	public boolean isTransparent(int rgba) {
		return (rgba & 0x000000ff) == 0;
	}
}
