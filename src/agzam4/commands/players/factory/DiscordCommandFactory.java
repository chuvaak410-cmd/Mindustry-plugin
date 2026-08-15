package agzam4.commands.players.factory;

import agzam4.commands.players.DiscordCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link DiscordCommand} leaf command. Pure indirection: identical
 * to the original {@code new DiscordCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class DiscordCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new DiscordCommand();
	}

	@Override
	public String commandName() {
		return "DiscordCommand";
	}
}
