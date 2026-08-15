package agzam4.commands.any.factory;

import agzam4.commands.any.SmvoteCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link SmvoteCommand} leaf command. Pure indirection: identical
 * to the original {@code new SmvoteCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class SmvoteCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new SmvoteCommand();
	}

	@Override
	public String commandName() {
		return "SmvoteCommand";
	}
}
