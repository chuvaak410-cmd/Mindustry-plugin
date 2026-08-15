package agzam4.commands.server.factory;

import agzam4.commands.server.ThreadsCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link ThreadsCommand} leaf command. Pure indirection: identical
 * to the original {@code new ThreadsCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class ThreadsCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new ThreadsCommand();
	}

	@Override
	public String commandName() {
		return "ThreadsCommand";
	}
}
