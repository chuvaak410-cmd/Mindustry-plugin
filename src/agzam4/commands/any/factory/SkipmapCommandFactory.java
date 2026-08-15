package agzam4.commands.any.factory;

import agzam4.commands.any.SkipmapCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link SkipmapCommand} leaf command. Pure indirection: identical
 * to the original {@code new SkipmapCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class SkipmapCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new SkipmapCommand();
	}

	@Override
	public String commandName() {
		return "SkipmapCommand";
	}
}
