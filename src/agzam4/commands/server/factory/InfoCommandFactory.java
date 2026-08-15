package agzam4.commands.server.factory;

import agzam4.commands.server.InfoCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link InfoCommand} leaf command. Pure indirection: identical
 * to the original {@code new InfoCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class InfoCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new InfoCommand();
	}

	@Override
	public String commandName() {
		return "InfoCommand";
	}
}
