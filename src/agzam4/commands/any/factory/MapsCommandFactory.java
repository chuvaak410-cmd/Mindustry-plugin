package agzam4.commands.any.factory;

import agzam4.commands.any.AvailableMapEnumerationCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link AvailableMapEnumerationCommand} leaf command. Pure indirection: identical
 * to the original {@code new AvailableMapEnumerationCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class MapsCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new AvailableMapEnumerationCommand();
	}

	@Override
	public String commandName() {
		return "MapsCommand";
	}
}
