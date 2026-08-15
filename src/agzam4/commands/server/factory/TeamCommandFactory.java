package agzam4.commands.server.factory;

import agzam4.commands.server.TeamCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link TeamCommand} leaf command. Pure indirection: identical
 * to the original {@code new TeamCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class TeamCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new TeamCommand();
	}

	@Override
	public String commandName() {
		return "TeamCommand";
	}
}
