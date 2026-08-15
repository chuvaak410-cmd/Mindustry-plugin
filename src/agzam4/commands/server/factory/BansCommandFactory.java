package agzam4.commands.server.factory;

import agzam4.commands.server.BansCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link BansCommand} leaf command. Pure indirection: identical
 * to the original {@code new BansCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class BansCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new BansCommand();
	}

	@Override
	public String commandName() {
		return "BansCommand";
	}
}
