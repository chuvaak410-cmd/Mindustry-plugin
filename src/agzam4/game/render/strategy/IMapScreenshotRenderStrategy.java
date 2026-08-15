package agzam4.game.render.strategy;

import java.awt.image.BufferedImage;

import mindustry.gen.Player;

/**
 * The two {@code Images.screenshot(...)} overloads' pixel-rendering logic,
 * reading from {@link agzam4.game.render.registry.IMapColorPaletteRegistry}'s
 * color cache instead of a local field.
 */
public interface IMapScreenshotRenderStrategy {

	BufferedImage screenshot(Player player);

	BufferedImage screenshot(int sx, int sy, int w, int h, boolean single);
}
