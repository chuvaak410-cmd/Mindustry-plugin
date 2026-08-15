package agzam4.achievements.provider;

import agzam4.achievements.AchievementsManager;
import arc.struct.ObjectMap;

/**
 * Default {@link IAchievementsManagerProvider}, delegating to the unchanged
 * {@link AchievementsManager} statics.
 */
public class AchievementsManagerProvider implements IAchievementsManagerProvider {

	@Override
	public void initialize() {
		AchievementsManager.init();
	}

	@Override
	public void updateMaps() {
		AchievementsManager.updateMaps();
	}

	@Override
	public int mapId() {
		return AchievementsManager.mapId();
	}

	@Override
	public ObjectMap<String, Integer> mapsIds() {
		return AchievementsManager.mapsIds;
	}
}
