package agzam4.commands.server.factory;

import agzam4.commands.server.SetnickCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link SetnickCommand} leaf command. Pure indirection: identical
 * to the original {@code new SetnickCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class SetnickCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new SetnickCommand();
	}

	@Override
	public String commandName() {
		return "SetnickCommand";
	}
}
