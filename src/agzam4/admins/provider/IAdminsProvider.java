package agzam4.admins.provider;

import agzam4.admins.AdminData;
import agzam4.commands.Permissions;
import arc.util.Nullable;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerInfo;

/** Delegating contract over the static {@link agzam4.admins.Admins} facade. */
public interface IAdminsProvider {

	void initialize();

	@Nullable AdminData adminData(@Nullable Player player);

	@Nullable AdminData adminData(@Nullable PlayerInfo info);

	boolean has(Object any, String permission);

	boolean has(Object any, Permissions permission);

	boolean add(@Nullable Player player);

	boolean remove(@Nullable Player player);

	void save();

	void load();
}
