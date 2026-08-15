package agzam4.admins.strategy;

import agzam4.admins.registry.AdminRegistry;
import agzam4.bot.TUser.MessageData;
import agzam4.commands.Permissions;
import agzam4.commands.Server;
import agzam4.utils.ApplicationDiagnosticMessageGateway;
import mindustry.gen.Player;

/** Default {@link IAdminPermissionStrategy}, mirroring the original {@code Admins.has(...)} logic exactly. */
public class AdminPermissionStrategyImpl implements IAdminPermissionStrategy {

	@Override
	public boolean has(Object any, String string) {
		if(any instanceof Player player) return has(player, string);
		if(any instanceof Server) return true;
		if(any instanceof MessageData data) return data.hasPermissions(string);
		ApplicationDiagnosticMessageGateway.warn("unimpleneted righs check for @", any.getClass());
		return false;
	}

	@Override
	public boolean has(Object any, Permissions permissions) {
		if(any instanceof Player player) return has(player, permissions);
		if(any instanceof Server) return true;
		ApplicationDiagnosticMessageGateway.warn("unimpleneted righs check for @", any.getClass());
		return false;
	}

	@Override
	public boolean has(Player player, String string) {
		if(player.admin) return true;
		var data = AdminRegistry.instance().get(player.getInfo());
		if(data == null) return false;
		if(!player.usid().equals(data.usid)) return false;
		return data.has(string);
	}

	@Override
	public boolean has(Player player, Permissions permissions) {
		return has(player, permissions.name);
	}
}
