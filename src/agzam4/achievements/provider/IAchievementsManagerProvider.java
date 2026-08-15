package agzam4.achievements.provider;

import arc.struct.ObjectMap;

/** Delegating contract over the static {@link agzam4.achievements.AchievementsManager} facade. */
public interface IAchievementsManagerProvider {

	void initialize();

	void updateMaps();

	int mapId();

	ObjectMap<String, Integer> mapsIds();
}
