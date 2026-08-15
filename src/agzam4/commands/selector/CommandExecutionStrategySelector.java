package agzam4.commands.selector;

import agzam4.commands.strategy.ICommandExecutionStrategy;
import agzam4.commands.strategy.SequentialExecutionStrategy;

/**
 * Chooses the {@link ICommandExecutionStrategy} to use when flushing
 * registered commands into their handlers. Today it always selects
 * {@link SequentialExecutionStrategy}, but is written as a selector so a
 * future strategy could be plugged in behind this single call site.
 */
public class CommandExecutionStrategySelector {

	private static final ICommandExecutionStrategy DEFAULT_STRATEGY = new SequentialExecutionStrategy();

	public ICommandExecutionStrategy selectStrategy() {
		return DEFAULT_STRATEGY;
	}
}
