package agzam4.commands.admin.factory;

import agzam4.commands.admin.UnitCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link UnitCommand} leaf command. Pure indirection: identical
 * to the original {@code new UnitCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class UnitCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new UnitCommand();
	}

	@Override
	public String commandName() {
		return "UnitCommand";
	}
}
