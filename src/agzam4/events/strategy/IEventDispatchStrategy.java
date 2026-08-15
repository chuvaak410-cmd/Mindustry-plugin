package agzam4.events.strategy;

/**
 * Strategy for how a periodic "tick" style update is dispatched to the
 * event subsystem. Only one implementation exists
 * ({@link DefaultEventDispatchStrategy}), mirroring the plugin's original
 * always-synchronous update loop, but the seam allows a future strategy
 * (e.g. rate-limited dispatch) to be swapped in.
 */
public interface IEventDispatchStrategy {

	void dispatchUpdate(Runnable updateOperation);

	default void dispatchIf(boolean condition, Runnable operation) {
		if(condition) operation.run();
	}
}
