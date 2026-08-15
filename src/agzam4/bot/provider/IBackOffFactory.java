package agzam4.bot.provider;

import org.telegram.telegrambots.meta.generics.BackOff;

/** Factory contract producing {@link agzam4.bot.ExponentialBackOff} instances. */
public interface IBackOffFactory {

	BackOff create();
}
