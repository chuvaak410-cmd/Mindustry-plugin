package agzam4.game.render.strategy;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The overlay text/line annotation pass that used to be
 * {@code Images.drawData}/{@code drawString}/{@code isTransparent}.
 */
public interface IScreenshotAnnotationRenderStrategy {

	void drawData(BufferedImage screen, boolean single, int dx, int dy);

	void drawString(BufferedImage img, Graphics2D g, String text, arc.graphics.Color color, int x, int y);

	boolean isTransparent(int rgba);
}
