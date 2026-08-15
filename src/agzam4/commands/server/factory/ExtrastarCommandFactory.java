package agzam4.commands.server.factory;

import agzam4.commands.server.ExtrastarCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link ExtrastarCommand} leaf command. Pure indirection: identical
 * to the original {@code new ExtrastarCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class ExtrastarCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new ExtrastarCommand();
	}

	@Override
	public String commandName() {
		return "ExtrastarCommand";
	}
}
