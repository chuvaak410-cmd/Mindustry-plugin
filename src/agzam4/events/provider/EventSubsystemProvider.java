package agzam4.events.provider;

import agzam4.events.EventMap;
import agzam4.events.ServerEventsManager;

/**
 * Default {@link IEventSubsystemProvider}. Delegates directly to
 * {@link ServerEventsManager#init()} and {@link EventMap#load()} - no change
 * in behaviour, only reached through the provider layer now.
 */
public class EventSubsystemProvider implements IEventSubsystemProvider {

	@Override
	public void initializeEventSubsystem() {
		ServerEventsManager.init();
	}

	@Override
	public void loadEventMap() {
		EventMap.load();
	}
}
