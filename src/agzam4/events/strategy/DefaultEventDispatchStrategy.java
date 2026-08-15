package agzam4.events.strategy;

/**
 * Dispatches the update operation synchronously, exactly as the original
 * {@code Events.run(Trigger.update, ...)} handler in {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint} did.
 */
public class DefaultEventDispatchStrategy implements IEventDispatchStrategy {

	@Override
	public void dispatchUpdate(Runnable updateOperation) {
		updateOperation.run();
	}
}
