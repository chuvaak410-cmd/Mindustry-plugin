package agzam4.commands.factory;

import agzam4.CommandsManager;

/**
 * Produces and registers the administrative/server command group
 * (admin/tempban/permban/config/nextmap/... - see
 * {@link CommandsManager#registerAdminCommands()}).
 */
public class AdminCommandGroupFactory implements ICommandFactory {

	@Override
	public void createAndRegisterCommands() {
		CommandsManager.registerAdminCommands();
	}

	@Override
	public String commandGroupName() {
		return "admin-commands";
	}
}
