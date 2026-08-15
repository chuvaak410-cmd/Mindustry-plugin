package agzam4.commands.server.factory;

import agzam4.commands.server.SetcustomCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link SetcustomCommand} leaf command. Pure indirection: identical
 * to the original {@code new SetcustomCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class SetcustomCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new SetcustomCommand();
	}

	@Override
	public String commandName() {
		return "SetcustomCommand";
	}
}
