package agzam4.bot.factory;

import agzam4.bot.TelegramBot;

/**
 * Default {@link IBotSessionFactory}. Delegates to
 * {@link TelegramBot#init()}, which reads the stored bot token (if any),
 * registers the long-polling session via {@link agzam4.bot.DaemonBotSession},
 * and loads persisted users/chats - all unchanged.
 */
public class BotSessionFactory implements IBotSessionFactory {

	@Override
	public void createAndStartSession() {
		TelegramBot.init();
	}
}
