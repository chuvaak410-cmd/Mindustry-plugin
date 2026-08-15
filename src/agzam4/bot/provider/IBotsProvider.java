package agzam4.bot.provider;

import java.awt.image.BufferedImage;

import agzam4.bot.Bots.NotifyTag;

/** Delegating contract over the static {@link agzam4.bot.Bots} notification facade. */
public interface IBotsProvider {

	void notify(NotifyTag tag, BufferedImage image);

	void notify(NotifyTag tag, String message);

	void notify(NotifyTag tag, String message, String superMessage);
}
