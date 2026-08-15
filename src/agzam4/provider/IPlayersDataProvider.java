package agzam4.provider;

import agzam4.managers.PlayerData;

/** Delegating contract over the static {@link agzam4.managers.PlayersData} facade. */
public interface IPlayersDataProvider {

	void initialize();

	PlayerData getData(String uuid);

	PlayerData data(String uuid);

	void save();
}
