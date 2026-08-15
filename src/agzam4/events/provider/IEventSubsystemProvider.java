package agzam4.events.provider;

/**
 * Supplies the initialized event subsystem (custom map/server events loaded
 * via {@link agzam4.events.EventsLoader} and coordinated by
 * {@link agzam4.events.ServerEventsManager}).
 */
public interface IEventSubsystemProvider {

	void initializeEventSubsystem();

	void loadEventMap();
}
