package agzam4.commands.server.factory;

import agzam4.commands.server.HelperCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link HelperCommand} leaf command. Pure indirection: identical
 * to the original {@code new HelperCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class HelperCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new HelperCommand();
	}

	@Override
	public String commandName() {
		return "HelperCommand";
	}
}
