package agzam4.admins.provider;

import agzam4.admins.AdminData;
import mindustry.net.Administration.PlayerInfo;

/** Default {@link IAdminDataFactory}, delegating to the unchanged {@link AdminData#from(PlayerInfo)}. */
public class AdminDataFactory implements IAdminDataFactory {

	@Override
	public AdminData create(PlayerInfo info) {
		return AdminData.from(info);
	}
}
