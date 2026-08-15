package agzam4.admins.io;

import agzam4.admins.AdminData;
import agzam4.admins.registry.AdminRegistry;
import arc.files.Fi;
import mindustry.Vars;

/** Default {@link IAdminPersistenceGateway}, mirroring the original {@code Admins.load()}/{@code save()} logic exactly. */
public class AdminPersistenceGatewayImpl implements IAdminPersistenceGateway {

	@Override
	public void load(Fi save) {
		if(!save.exists()) return;
		String[] data = save.readString().split("\n");
		for (int i = 0; i < data.length; i++) {
			String[] args = data[i].split(" ");
			if(args.length < 2) continue;
			var info = Vars.netServer.admins.getInfo(args[0]);
			if(info == null) continue;
			var ad = AdminData.from(info);
			ad.usid = args[1];
			for (int j = 2; j < args.length; j++) {
				ad.add(args[j]);
			}
			AdminRegistry.instance().put(info, ad);
		}
	}

	@Override
	public void save(Fi save) {
		StringBuilder result = new StringBuilder();
		AdminRegistry.instance().admins().each((info, data) -> {
			if(result.length() != 0) result.append('\n');
			result.append(info.id);
			result.append(' ');
			result.append(data.usid);
			result.append(' ');
			result.append(data.permissionsAsString(' '));
		});
		save.writeString(result.toString(), false);
	}
}
