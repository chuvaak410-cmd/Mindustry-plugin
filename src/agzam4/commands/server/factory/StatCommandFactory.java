package agzam4.commands.server.factory;

import agzam4.commands.server.StatCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link StatCommand} leaf command. Pure indirection: identical
 * to the original {@code new StatCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class StatCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new StatCommand();
	}

	@Override
	public String commandName() {
		return "StatCommand";
	}
}
