package agzam4.commands.server.factory;

import agzam4.commands.server.ChatfilterCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link ChatfilterCommand} leaf command. Pure indirection: identical
 * to the original {@code new ChatfilterCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class ChatfilterCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new ChatfilterCommand();
	}

	@Override
	public String commandName() {
		return "ChatfilterCommand";
	}
}
