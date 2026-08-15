package agzam4.commands.server.factory;

import agzam4.commands.server.AsCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link AsCommand} leaf command. Pure indirection: identical
 * to the original {@code new AsCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class AsCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new AsCommand();
	}

	@Override
	public String commandName() {
		return "AsCommand";
	}
}
