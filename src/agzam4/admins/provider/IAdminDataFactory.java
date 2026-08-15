package agzam4.admins.provider;

import agzam4.admins.AdminData;
import mindustry.net.Administration.PlayerInfo;

/** Factory contract mirroring {@link AdminData#from(PlayerInfo)}. */
public interface IAdminDataFactory {

	AdminData create(PlayerInfo info);
}
