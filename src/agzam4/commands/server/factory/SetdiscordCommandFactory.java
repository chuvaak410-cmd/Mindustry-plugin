package agzam4.commands.server.factory;

import agzam4.commands.server.SetdiscordCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link SetdiscordCommand} leaf command. Pure indirection: identical
 * to the original {@code new SetdiscordCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class SetdiscordCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new SetdiscordCommand();
	}

	@Override
	public String commandName() {
		return "SetdiscordCommand";
	}
}
