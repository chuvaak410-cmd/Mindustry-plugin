package agzam4.admins.registry;

import agzam4.admins.AdminData;
import arc.struct.ObjectMap;
import arc.util.Nullable;
import mindustry.net.Administration.PlayerInfo;

/**
 * Singleton default {@link IAdminRegistry}. Owns the same
 * {@code ObjectMap<PlayerInfo, AdminData>} that used to be a private static
 * field on {@link agzam4.admins.Admins} - lookup/mutation semantics are
 * unchanged, just relocated here.
 */
public final class AdminRegistry implements IAdminRegistry {

	private static final AdminRegistry INSTANCE = new AdminRegistry();

	private ObjectMap<PlayerInfo, AdminData> admins;

	private AdminRegistry() {}

	public static AdminRegistry instance() {
		return INSTANCE;
	}

	@Override
	public void reset() {
		admins = new ObjectMap<>();
	}

	@Override
	public ObjectMap<PlayerInfo, AdminData> admins() {
		return admins;
	}

	@Override
	public @Nullable AdminData get(PlayerInfo info) {
		return admins.get(info);
	}

	@Override
	public void put(PlayerInfo info, AdminData data) {
		admins.put(info, data);
	}

	@Override
	public boolean containsKey(PlayerInfo info) {
		return admins.containsKey(info);
	}

	@Override
	public boolean remove(PlayerInfo info) {
		return admins.remove(info) != null;
	}
}
