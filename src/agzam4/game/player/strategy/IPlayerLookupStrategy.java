package agzam4.game.player.strategy;

import arc.util.Nullable;
import mindustry.gen.Player;

/**
 * One step of the ordered lookup chain that used to be inline in
 * {@code MindustryGameRuntimeFacade.findPlayer(String)}. Each implementation is one of the
 * original sequential checks, in the exact original order.
 */
public interface IPlayerLookupStrategy {

	@Nullable Player find(String query);
}
