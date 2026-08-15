package agzam4.commands.admin.factory;

import agzam4.commands.admin.PermbanCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link PermbanCommand} leaf command. Pure indirection: identical
 * to the original {@code new PermbanCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class PermbanCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new PermbanCommand();
	}

	@Override
	public String commandName() {
		return "PermbanCommand";
	}
}
