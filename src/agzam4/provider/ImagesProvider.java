package agzam4.provider;

import java.awt.image.BufferedImage;

import agzam4.game.Images;
import mindustry.gen.Player;

/** Default {@link IImagesProvider}, delegating to the unchanged {@link Images} statics. */
public class ImagesProvider implements IImagesProvider {

	@Override
	public void initialize() {
		Images.init();
	}

	@Override
	public BufferedImage screenshot(Player player) {
		return Images.screenshot(player);
	}

	@Override
	public BufferedImage screenshot(int sx, int sy, int w, int h, boolean single) {
		return Images.screenshot(sx, sy, w, h, single);
	}
}
