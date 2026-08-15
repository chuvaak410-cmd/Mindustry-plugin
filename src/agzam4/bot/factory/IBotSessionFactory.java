package agzam4.bot.factory;

/**
 * Constructs and starts the telegram bot session used by
 * {@link agzam4.bot.TelegramBot}.
 */
public interface IBotSessionFactory {

	void createAndStartSession();
}
