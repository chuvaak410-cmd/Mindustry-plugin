package agzam4.game.player.strategy;

import arc.util.Nullable;
import mindustry.gen.Groups;
import mindustry.gen.Player;

/**
 * Exact name match step of {@code MindustryGameRuntimeFacade.findPlayer}. Used twice in the
 * original lookup chain (second and third steps) - the second use appears
 * to be dead/duplicate logic against the same unmodified query string, but
 * it is preserved here exactly as-is rather than "fixed", matching the
 * task's preserve-behavior-exactly requirement.
 */
public class ExactNameMatchPlayerLookupStrategyImpl implements IPlayerLookupStrategy {

	@Override
	public @Nullable Player find(String query) {
		return Groups.player.find(p -> p.name.equals(query));
	}
}
