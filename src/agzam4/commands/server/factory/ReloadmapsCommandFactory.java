package agzam4.commands.server.factory;

import agzam4.commands.server.ReloadmapsCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link ReloadmapsCommand} leaf command. Pure indirection: identical
 * to the original {@code new ReloadmapsCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class ReloadmapsCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new ReloadmapsCommand();
	}

	@Override
	public String commandName() {
		return "ReloadmapsCommand";
	}
}
