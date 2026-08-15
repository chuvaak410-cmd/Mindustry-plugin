package agzam4.commands.any.factory;

import agzam4.commands.any.VoteCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link VoteCommand} leaf command. Pure indirection: identical
 * to the original {@code new VoteCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class VoteCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new VoteCommand();
	}

	@Override
	public String commandName() {
		return "VoteCommand";
	}
}
