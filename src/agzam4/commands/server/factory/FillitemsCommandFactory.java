package agzam4.commands.server.factory;

import agzam4.commands.server.FillitemsCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link FillitemsCommand} leaf command. Pure indirection: identical
 * to the original {@code new FillitemsCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class FillitemsCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new FillitemsCommand();
	}

	@Override
	public String commandName() {
		return "FillitemsCommand";
	}
}
