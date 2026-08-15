package agzam4.bot.provider;

/** Delegating contract over the static {@link agzam4.bot.TelegramBot} lifecycle facade. */
public interface ITelegramBotProvider {

	void initialize();

	void load();

	void save();

	void stop();

	String strip(String text);
}
