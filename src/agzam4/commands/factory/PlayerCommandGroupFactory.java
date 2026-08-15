package agzam4.commands.factory;

import agzam4.CommandsManager;

/**
 * Produces and registers the in-game player command group
 * (help/votekick/discord/skipmap/... - see {@link CommandsManager#registerPlayersCommands()}).
 */
public class PlayerCommandGroupFactory implements ICommandFactory {

	@Override
	public void createAndRegisterCommands() {
		CommandsManager.registerPlayersCommands();
	}

	@Override
	public String commandGroupName() {
		return "player-commands";
	}
}
