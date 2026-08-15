package agzam4.admins.provider;

import agzam4.admins.AdminData;
import agzam4.admins.Admins;
import agzam4.commands.Permissions;
import arc.util.Nullable;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerInfo;

/** Default {@link IAdminsProvider}, delegating to the unchanged {@link Admins} statics. */
public class AdminsProvider implements IAdminsProvider {

	@Override
	public void initialize() {
		Admins.init();
	}

	@Override
	public @Nullable AdminData adminData(@Nullable Player player) {
		return Admins.adminData(player);
	}

	@Override
	public @Nullable AdminData adminData(@Nullable PlayerInfo info) {
		return Admins.adminData(info);
	}

	@Override
	public boolean has(Object any, String permission) {
		return Admins.has(any, permission);
	}

	@Override
	public boolean has(Object any, Permissions permission) {
		return Admins.has(any, permission);
	}

	@Override
	public boolean add(@Nullable Player player) {
		return Admins.add(player);
	}

	@Override
	public boolean remove(@Nullable Player player) {
		return Admins.remove(player);
	}

	@Override
	public void save() {
		Admins.save();
	}

	@Override
	public void load() {
		Admins.load();
	}
}
