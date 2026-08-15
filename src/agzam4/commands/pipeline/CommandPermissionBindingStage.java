package agzam4.commands.pipeline;

import agzam4.commands.factory.ICommandFactory;

/**
 * Permission binding is performed inline by {@link agzam4.CommandsManager}
 * itself (via {@code PlayerCommand.admin(true)} and the
 * {@code CommandSender.hasPermissions} checks executed at dispatch time), so
 * this stage is a documented no-op placeholder that keeps the pipeline shape
 * consistent with the rest of the architecture and gives future permission
 * pre-computation a designated home.
 */
public class CommandPermissionBindingStage implements ICommandRegistrationStage {

	@Override
	public void process(ICommandFactory factory) {
		// Permission checks for the commands produced by `factory` are
		// resolved lazily at execution time by CommandsManager.PlayerCommand
		// and CommandsManager.BotCommand - nothing to precompute here.
	}

	@Override
	public String stageName() {
		return "permission-binding";
	}
}
