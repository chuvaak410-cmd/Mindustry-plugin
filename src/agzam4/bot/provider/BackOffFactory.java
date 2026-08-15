package agzam4.bot.provider;

import org.telegram.telegrambots.meta.generics.BackOff;

import agzam4.bot.ExponentialBackOff;

/** Default {@link IBackOffFactory}, delegating to the unchanged {@link ExponentialBackOff}. */
public class BackOffFactory implements IBackOffFactory {

	@Override
	public BackOff create() {
		return new ExponentialBackOff();
	}
}
