package agzam4.commands.factory;

import agzam4.CommandsManager;

/**
 * Produces and registers the telegram-bot-only command group
 * (help/players/player/this/map/... - see {@link CommandsManager#registerBotCommands()}).
 */
public class BotCommandGroupFactory implements ICommandFactory {

	@Override
	public void createAndRegisterCommands() {
		CommandsManager.registerBotCommands();
	}

	@Override
	public String commandGroupName() {
		return "bot-commands";
	}
}
