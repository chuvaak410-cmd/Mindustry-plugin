package agzam4.commands.any.factory;

import agzam4.commands.any.MapinfoCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link MapinfoCommand} leaf command. Pure indirection: identical
 * to the original {@code new MapinfoCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class MapinfoCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new MapinfoCommand();
	}

	@Override
	public String commandName() {
		return "MapinfoCommand";
	}
}
