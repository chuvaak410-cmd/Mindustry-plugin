package agzam4.provider;

import agzam4.managers.PlayerData;
import agzam4.managers.PlayersData;

/**
 * Default {@link IPlayersDataProvider}. Delegates to the unchanged static
 * {@link PlayersData} methods.
 */
public class PlayersDataProvider implements IPlayersDataProvider {

	@Override
	public void initialize() {
		PlayersData.init();
	}

	@Override
	public PlayerData getData(String uuid) {
		return PlayersData.getData(uuid);
	}

	@Override
	public PlayerData data(String uuid) {
		return PlayersData.data(uuid);
	}

	@Override
	public void save() {
		PlayersData.save();
	}
}
