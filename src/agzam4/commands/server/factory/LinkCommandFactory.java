package agzam4.commands.server.factory;

import agzam4.commands.server.LinkCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link LinkCommand} leaf command. Pure indirection: identical
 * to the original {@code new LinkCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class LinkCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new LinkCommand();
	}

	@Override
	public String commandName() {
		return "LinkCommand";
	}
}
