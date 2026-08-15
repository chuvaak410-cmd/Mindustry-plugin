package agzam4.commands.server.factory;

import agzam4.commands.server.EventCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link EventCommand} leaf command. Pure indirection: identical
 * to the original {@code new EventCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class EventCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new EventCommand();
	}

	@Override
	public String commandName() {
		return "EventCommand";
	}
}
