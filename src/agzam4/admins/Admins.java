package agzam4.admins;

import agzam4.admins.io.AdminPersistenceGatewayImpl;
import agzam4.admins.io.IAdminPersistenceGateway;
import agzam4.admins.registry.AdminRegistry;
import agzam4.commands.Permissions;
import agzam4.admins.strategy.AdminPermissionStrategyImpl;
import agzam4.admins.strategy.IAdminPermissionStrategy;
import arc.files.Fi;
import arc.struct.ObjectMap;
import arc.util.Nullable;
import mindustry.Vars;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerInfo;

public class Admins {

	private static final IAdminPermissionStrategy permissionStrategy = new AdminPermissionStrategyImpl();
	private static final IAdminPersistenceGateway persistenceGateway = new AdminPersistenceGatewayImpl();

	private static Fi save;

	public static void init() {
		save = new Fi(Vars.saveDirectory + "/admins_data.txt", Vars.saveDirectory.type());
		AdminRegistry.instance().reset();
//		Vars.netServer.admins.getAdmins().forEach(i -> admins.put(i, AdminData.from(i)));
		load();
	}

	public static @Nullable AdminData adminData(@Nullable Player player) {
		if(player == null) return null;
		return adminData(player.getInfo());
	}

	public static @Nullable AdminData adminData(@Nullable PlayerInfo info) {
		if(info == null) return null;
		return AdminRegistry.instance().get(info);
	}

	public static boolean has(Object any, String string) {
		return permissionStrategy.has(any, string);
	}

	public static boolean has(Object any, Permissions permissions) {
		return permissionStrategy.has(any, permissions);
	}

	public static boolean has(Player player, String string) {
		return permissionStrategy.has(player, string);
	}

	public static boolean has(Player player, Permissions permissions) {
		return permissionStrategy.has(player, permissions);
	}

	/**
	 * @param player - target player
	 * @return true of player was added or null if player is null or already added
	 */
	public static boolean add(@Nullable Player player) {
		if(player == null) return false;
		if(AdminRegistry.instance().containsKey(player.getInfo())) return false;
		AdminData data = AdminData.from(player.getInfo());
		data.usid = player.usid();
		AdminRegistry.instance().put(player.getInfo(), data);
		return true;
	}

	/**
	 * @param player - target player
	 * @return true of player was removed or null if player is null or not found
	 */
	public static boolean remove(@Nullable Player player) {
		if(player == null) return false;
		return AdminRegistry.instance().remove(player.getInfo());
	}

	public static boolean remove(@Nullable PlayerInfo player) {
		if(player == null) return false;
		return AdminRegistry.instance().remove(player);
	}

	public static boolean refresh(@Nullable Player player) {
		if(player == null) return false;
		var data = adminData(player.getInfo());
		if(data == null) return false;
		data.usid = player.usid();
		return true;
	}

	public static void load() {
		persistenceGateway.load(save);
	}

	public static void save() {
		persistenceGateway.save(save);
	}

	public static ObjectMap<PlayerInfo, AdminData> admins() {
		return AdminRegistry.instance().admins();
	}
}
