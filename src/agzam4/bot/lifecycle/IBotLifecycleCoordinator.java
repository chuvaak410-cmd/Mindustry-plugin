package agzam4.bot.lifecycle;

/**
 * Coordinates the telegram bot subsystem's lifecycle: startup (session
 * creation) and, in the future, orderly shutdown.
 */
public interface IBotLifecycleCoordinator {

	void startBotSession();
}
