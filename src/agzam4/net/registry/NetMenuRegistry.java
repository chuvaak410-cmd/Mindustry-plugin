package agzam4.net.registry;

import agzam4.net.NetMenu;
import arc.struct.IntMap;

/**
 * Singleton default {@link INetMenuRegistry}. Owns the same
 * {@code IntMap<NetMenu>} plus incrementing counter that used to be static
 * fields on {@link NetMenu} itself ({@code menus}/{@code ids}) - moved here
 * unchanged so {@code NetMenu} no longer needs to be its own registry.
 */
public final class NetMenuRegistry implements INetMenuRegistry {

	private static final NetMenuRegistry INSTANCE = new NetMenuRegistry();

	private int ids = 0;
	private final IntMap<NetMenu> menus = new IntMap<>();

	private NetMenuRegistry() {}

	public static NetMenuRegistry instance() {
		return INSTANCE;
	}

	@Override
	public int register(NetMenu menu) {
		int id = ids;
		menus.put(id, menu);
		ids++;
		return id;
	}

	@Override
	public NetMenu remove(int id) {
		return menus.remove(id);
	}
}
