package agzam4.provider;

import java.awt.image.BufferedImage;

import mindustry.gen.Player;

/** Delegating contract over the static {@link agzam4.game.Images} facade. */
public interface IImagesProvider {

	void initialize();

	BufferedImage screenshot(Player player);

	BufferedImage screenshot(int sx, int sy, int w, int h, boolean single);
}
