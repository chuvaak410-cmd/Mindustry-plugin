package agzam4.commands.server.factory;

import agzam4.commands.server.RunwaveCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link RunwaveCommand} leaf command. Pure indirection: identical
 * to the original {@code new RunwaveCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class RunwaveCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new RunwaveCommand();
	}

	@Override
	public String commandName() {
		return "RunwaveCommand";
	}
}
