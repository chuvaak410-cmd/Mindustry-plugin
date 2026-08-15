package agzam4.achievements.provider;

import agzam4.achievements.PlayerAchievements;

/** Default {@link IPlayerAchievementsFactory}, delegating to the unchanged {@code new PlayerAchievements()}. */
public class PlayerAchievementsFactory implements IPlayerAchievementsFactory {

	@Override
	public PlayerAchievements create() {
		return new PlayerAchievements();
	}
}
