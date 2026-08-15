package agzam4.admins.strategy;

import agzam4.commands.Permissions;
import mindustry.gen.Player;

/**
 * The {@code has(...)} branching logic that used to live directly on
 * {@link agzam4.admins.Admins}, deciding permission checks for players,
 * the server console ({@code Server}), and bot senders ({@code MessageData}).
 */
public interface IAdminPermissionStrategy {

	boolean has(Object any, String permission);

	boolean has(Object any, Permissions permission);

	boolean has(Player player, String permission);

	boolean has(Player player, Permissions permission);
}
