package agzam4.bot.provider;

import agzam4.bot.factory.IBotSessionFactory;

/**
 * Supplies the {@link IBotSessionFactory} used to stand up the telegram bot
 * session.
 */
public interface IBotSessionProvider {

	IBotSessionFactory provideBotSessionFactory();
}
