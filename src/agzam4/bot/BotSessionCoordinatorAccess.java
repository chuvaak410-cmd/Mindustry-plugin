package agzam4.bot;

import agzam4.bot.lifecycle.BotLifecycleCoordinator;
import agzam4.bot.lifecycle.IBotLifecycleCoordinator;

/**
 * DI-registered singleton bean giving the rest of the application a single
 * shared {@link IBotLifecycleCoordinator} instance, resolved through
 * {@link agzam4.dependencyinjection.IBeanFactory} instead of being
 * constructed ad-hoc.
 */
public class BotSessionCoordinatorAccess {

	private final IBotLifecycleCoordinator lifecycleCoordinator = new BotLifecycleCoordinator();

	public IBotLifecycleCoordinator lifecycleCoordinator() {
		return lifecycleCoordinator;
	}
}
