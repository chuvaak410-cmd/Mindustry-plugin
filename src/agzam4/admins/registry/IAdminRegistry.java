package agzam4.admins.registry;

import agzam4.admins.AdminData;
import arc.struct.ObjectMap;
import arc.util.Nullable;
import mindustry.net.Administration.PlayerInfo;

/**
 * Discoverable seam over the static {@code ObjectMap<PlayerInfo, AdminData>}
 * that used to live directly as a private static field on
 * {@link agzam4.admins.Admins}.
 */
public interface IAdminRegistry {

	/** Re-creates the backing map, matching the original {@code Admins.init()} reset. */
	void reset();

	ObjectMap<PlayerInfo, AdminData> admins();

	@Nullable AdminData get(PlayerInfo info);

	void put(PlayerInfo info, AdminData data);

	boolean containsKey(PlayerInfo info);

	boolean remove(PlayerInfo info);
}
