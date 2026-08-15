package agzam4.commands.admin.factory;

import agzam4.commands.admin.BrushCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link BrushCommand} leaf command. Pure indirection: identical
 * to the original {@code new BrushCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class BrushCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new BrushCommand();
	}

	@Override
	public String commandName() {
		return "BrushCommand";
	}
}
