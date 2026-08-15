package agzam4.commands.server.factory;

import agzam4.commands.server.ConfigCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link ConfigCommand} leaf command. Pure indirection: identical
 * to the original {@code new ConfigCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class ConfigCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new ConfigCommand();
	}

	@Override
	public String commandName() {
		return "ConfigCommand";
	}
}
