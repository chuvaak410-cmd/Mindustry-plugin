package agzam4.commands.server.factory;

import agzam4.commands.server.RestartCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link RestartCommand} leaf command. Pure indirection: identical
 * to the original {@code new RestartCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class RestartCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new RestartCommand();
	}

	@Override
	public String commandName() {
		return "RestartCommand";
	}
}
