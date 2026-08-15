package agzam4.commands.registry;

import agzam4.CommandsManager;
import agzam4.CommandsManager.BotCommand;
import agzam4.CommandsManager.PlayerCommand;
import arc.struct.Seq;

/**
 * Default {@link ICommandRegistry}. Delegates straight through to
 * {@link CommandsManager}, which continues to own the actual command
 * collections and dispatch semantics.
 */
public class CommandRegistry implements ICommandRegistry {

	@Override
	public Seq<PlayerCommand> playerCommands() {
		return CommandsManager.playerCommands();
	}

	@Override
	public Seq<BotCommand> botCommands() {
		return CommandsManager.botCommands();
	}

	@Override
	public void flushAll() {
		CommandsManager.flushCommands();
	}
}
