package agzam4.commands.admin.factory;

import agzam4.commands.admin.TempbanCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link TempbanCommand} leaf command. Pure indirection: identical
 * to the original {@code new TempbanCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class TempbanCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new TempbanCommand();
	}

	@Override
	public String commandName() {
		return "TempbanCommand";
	}
}
