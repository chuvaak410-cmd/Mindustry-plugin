package agzam4.commands.admin.factory;

import agzam4.commands.admin.BotCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link BotCommand} leaf command. Pure indirection: identical
 * to the original {@code new BotCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class BotCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new BotCommand();
	}

	@Override
	public String commandName() {
		return "BotCommand";
	}
}
