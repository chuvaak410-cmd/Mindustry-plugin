package agzam4.commands.admin.factory;

import agzam4.commands.admin.CustomCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link CustomCommand} leaf command. Pure indirection: identical
 * to the original {@code new CustomCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class CustomCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new CustomCommand();
	}

	@Override
	public String commandName() {
		return "CustomCommand";
	}
}
