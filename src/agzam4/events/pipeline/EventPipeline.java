package agzam4.events.pipeline;

import agzam4.events.ServerEventsManager;
import agzam4.events.strategy.DefaultEventDispatchStrategy;
import agzam4.events.strategy.IEventDispatchStrategy;

/**
 * Thin orchestration layer sitting above {@link ServerEventsManager}. Each
 * call to {@link #runUpdateTick()} corresponds exactly to the original
 * per-frame {@code ServerEventsManager.update()} call performed inside the
 * plugin's {@code Trigger.update} listener, now routed through an
 * {@link IEventDispatchStrategy}.
 */
public class EventPipeline {

	private final IEventDispatchStrategy dispatchStrategy = new DefaultEventDispatchStrategy();

	public void runUpdateTick() {
		dispatchStrategy.dispatchUpdate(ServerEventsManager::update);
	}
}
