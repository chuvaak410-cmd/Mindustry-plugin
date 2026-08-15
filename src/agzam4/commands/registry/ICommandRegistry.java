package agzam4.commands.registry;

import agzam4.CommandsManager.BotCommand;
import agzam4.CommandsManager.PlayerCommand;
import arc.struct.Seq;

/**
 * Central, discoverable lookup point for every command known to the plugin,
 * regardless of which receiver (player, server console, telegram bot) it was
 * registered for. Backed by the pre-existing {@link agzam4.CommandsManager}
 * collections so behaviour is unchanged - this registry is purely a facade
 * used by the new registration pipeline and by anything that wants to
 * discover commands without depending on {@code CommandsManager} directly.
 */
public interface ICommandRegistry {

	Seq<PlayerCommand> playerCommands();

	Seq<BotCommand> botCommands();

	void flushAll();
}
