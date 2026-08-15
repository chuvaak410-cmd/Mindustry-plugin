package agzam4.commands.strategy;

/**
 * Executes the flush operation synchronously on the calling thread, exactly
 * like the original plugin always did.
 */
public class SequentialExecutionStrategy implements ICommandExecutionStrategy {

	@Override
	public void execute(Runnable flushOperation) {
		flushOperation.run();
	}
}
