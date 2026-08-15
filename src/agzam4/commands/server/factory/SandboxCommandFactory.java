package agzam4.commands.server.factory;

import agzam4.commands.server.SandboxCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link SandboxCommand} leaf command. Pure indirection: identical
 * to the original {@code new SandboxCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class SandboxCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new SandboxCommand();
	}

	@Override
	public String commandName() {
		return "SandboxCommand";
	}
}
