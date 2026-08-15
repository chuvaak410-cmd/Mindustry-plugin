package agzam4.commands.players.factory;

import agzam4.commands.players.VotekickCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link VotekickCommand} leaf command. Pure indirection: identical
 * to the original {@code new VotekickCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class VotekickCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new VotekickCommand();
	}

	@Override
	public String commandName() {
		return "VotekickCommand";
	}
}
