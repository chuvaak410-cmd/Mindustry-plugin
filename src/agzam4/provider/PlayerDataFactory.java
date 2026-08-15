package agzam4.provider;

import agzam4.managers.PlayerData;

/** Default {@link IPlayerDataFactory}, delegating to the unchanged {@link PlayerData#from(String)}. */
public class PlayerDataFactory implements IPlayerDataFactory {

	@Override
	public PlayerData create(String uuid) {
		return PlayerData.from(uuid);
	}
}
