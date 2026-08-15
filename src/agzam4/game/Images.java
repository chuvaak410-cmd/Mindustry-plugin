package agzam4.game;

import java.awt.image.BufferedImage;

import agzam4.game.render.registry.IMapColorPaletteRegistry;
import agzam4.game.render.registry.MapColorPaletteRegistry;
import agzam4.game.render.strategy.IMapScreenshotRenderStrategy;
import agzam4.game.render.strategy.MapScreenshotRenderStrategyImpl;
import mindustry.gen.Player;

/**
 * Thin coordinator - every original method signature is preserved, but the
 * actual logic now lives behind {@code agzam4.game.render.*}. See
 * {@code ENTERPRISE_TRANSFORMATION.md} ("Pass 4") for the full breakdown.
 */
public class Images {

	private static final IMapColorPaletteRegistry colorPaletteRegistry = MapColorPaletteRegistry.instance();
	private static final IMapScreenshotRenderStrategy screenshotRenderStrategy = new MapScreenshotRenderStrategyImpl();

	public static BufferedImage placeholder = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);

	public static void init() {
		colorPaletteRegistry.init();
	}

	public static BufferedImage screenshot(Player player) {
		return screenshotRenderStrategy.screenshot(player);
	}

	public static BufferedImage screenshot(int sx, int sy, int w, int h, boolean single) {
		return screenshotRenderStrategy.screenshot(sx, sy, w, h, single);
	}
}
