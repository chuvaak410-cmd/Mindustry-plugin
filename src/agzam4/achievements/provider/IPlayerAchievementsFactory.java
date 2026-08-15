package agzam4.achievements.provider;

import agzam4.achievements.PlayerAchievements;

/** Factory contract for constructing {@link PlayerAchievements} instances through the provider layer. */
public interface IPlayerAchievementsFactory {

	PlayerAchievements create();
}
