package agzam4.commands.strategy;

/**
 * A strategy for how the set of registered command groups gets flushed into
 * their respective handlers (client/server/bot). Only one implementation
 * exists today ({@link SequentialExecutionStrategy}), matching the original
 * behaviour exactly, but the abstraction is kept so alternative strategies
 * (e.g. a hypothetical parallel or throttled flush) could be introduced
 * without touching call sites.
 */
public interface ICommandExecutionStrategy {

	void execute(Runnable flushOperation);
}
