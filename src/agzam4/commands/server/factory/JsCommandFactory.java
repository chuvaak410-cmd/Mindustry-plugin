package agzam4.commands.server.factory;

import agzam4.commands.server.JsCommand;
import agzam4.commands.factory.ICommandLeafFactory;
import agzam4.commands.CommandHandler;

/**
 * Constructs the {@link JsCommand} leaf command. Pure indirection: identical
 * to the original {@code new JsCommand()} call site, just reached through a
 * factory so the command is registry-discoverable.
 */
public class JsCommandFactory implements ICommandLeafFactory {

	@Override
	public CommandHandler<?> createCommand() {
		return new JsCommand();
	}

	@Override
	public String commandName() {
		return "JsCommand";
	}
}
