package agzam4.commands.admin.factory;

import agzam4.commands.admin.NickCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link NickCommand} leaf command. Pure indirection: identical
 * to the original {@code new NickCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class NickCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new NickCommand();
	}

	@Override
	public String commandName() {
		return "NickCommand";
	}
}
