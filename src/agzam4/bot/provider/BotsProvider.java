package agzam4.bot.provider;

import java.awt.image.BufferedImage;

import agzam4.bot.Bots;
import agzam4.bot.Bots.NotifyTag;

/** Default {@link IBotsProvider}, delegating to the unchanged {@link Bots} statics. */
public class BotsProvider implements IBotsProvider {

	@Override
	public void notify(NotifyTag tag, BufferedImage image) {
		Bots.notify(tag, image);
	}

	@Override
	public void notify(NotifyTag tag, String message) {
		Bots.notify(tag, message);
	}

	@Override
	public void notify(NotifyTag tag, String message, String superMessage) {
		Bots.notify(tag, message, superMessage);
	}
}
