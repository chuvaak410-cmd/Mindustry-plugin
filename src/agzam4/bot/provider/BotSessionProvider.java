package agzam4.bot.provider;

import agzam4.bot.factory.BotSessionFactory;
import agzam4.bot.factory.IBotSessionFactory;

public class BotSessionProvider implements IBotSessionProvider {

	private final IBotSessionFactory botSessionFactory = new BotSessionFactory();

	@Override
	public IBotSessionFactory provideBotSessionFactory() {
		return botSessionFactory;
	}
}
