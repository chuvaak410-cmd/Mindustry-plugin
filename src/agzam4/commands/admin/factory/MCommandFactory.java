package agzam4.commands.admin.factory;

import agzam4.commands.admin.MCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link MCommand} leaf command. Pure indirection: identical
 * to the original {@code new MCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class MCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new MCommand();
	}

	@Override
	public String commandName() {
		return "MCommand";
	}
}
