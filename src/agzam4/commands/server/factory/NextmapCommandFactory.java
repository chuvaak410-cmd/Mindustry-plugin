package agzam4.commands.server.factory;

import agzam4.commands.server.NextmapCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link NextmapCommand} leaf command. Pure indirection: identical
 * to the original {@code new NextmapCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class NextmapCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new NextmapCommand();
	}

	@Override
	public String commandName() {
		return "NextmapCommand";
	}
}
