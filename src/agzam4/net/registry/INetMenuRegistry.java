package agzam4.net.registry;

import agzam4.net.NetMenu;

/**
 * Discoverable seam over the static open-menus table that used to live
 * directly inside {@link agzam4.net.NetMenu} ({@code menus}/{@code ids}).
 * Assigns a fresh id to every menu shown to a player and allows the id to be
 * resolved back to the originating {@link NetMenu} exactly once (on option
 * choose), matching the original {@code IntMap<NetMenu>} semantics.
 */
public interface INetMenuRegistry {

	int register(NetMenu menu);

	NetMenu remove(int id);
}
