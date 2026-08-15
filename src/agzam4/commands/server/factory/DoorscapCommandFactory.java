package agzam4.commands.server.factory;

import agzam4.commands.server.DoorscapCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link DoorscapCommand} leaf command. Pure indirection: identical
 * to the original {@code new DoorscapCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class DoorscapCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new DoorscapCommand();
	}

	@Override
	public String commandName() {
		return "DoorscapCommand";
	}
}
