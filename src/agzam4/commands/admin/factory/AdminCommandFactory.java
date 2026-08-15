package agzam4.commands.admin.factory;

import agzam4.commands.admin.AdminCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link AdminCommand} leaf command. Pure indirection: identical
 * to the original {@code new AdminCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class AdminCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new AdminCommand();
	}

	@Override
	public String commandName() {
		return "AdminCommand";
	}
}
