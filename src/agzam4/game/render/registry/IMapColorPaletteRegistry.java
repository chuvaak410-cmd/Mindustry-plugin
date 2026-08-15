package agzam4.game.render.registry;

import arc.util.Nullable;

/**
 * Owns the per-block color-cache table and its {@code /colors.png}-driven
 * population, that used to be {@code Images.init()} plus its private
 * static {@code mapColors} field.
 */
public interface IMapColorPaletteRegistry {

	void init();

	/** Same nullability as the original {@code mapColors} field: null until {@link #init()} has run/succeeded. */
	@Nullable int[][] mapColors();
}
