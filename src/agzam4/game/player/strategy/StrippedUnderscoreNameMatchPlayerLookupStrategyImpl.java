package agzam4.game.player.strategy;

import agzam4.game.MindustryGameRuntimeFacade;
import arc.util.Nullable;
import mindustry.gen.Groups;
import mindustry.gen.Player;

/**
 * Fifth (final) step of {@code MindustryGameRuntimeFacade.findPlayer}: compares
 * {@code MindustryGameRuntimeFacade.strip(p.name).replaceAll(" ", "_")} against the pre-computed
 * stripped-and-underscored query. Calls {@link MindustryGameRuntimeFacade#strip(String)}
 * directly, same as the original code.
 */
public class StrippedUnderscoreNameMatchPlayerLookupStrategyImpl implements IPlayerLookupStrategy {

	@Override
	public @Nullable Player find(String strippedQuery) {
		return Groups.player.find(p -> MindustryGameRuntimeFacade.strip(p.name).replaceAll(" ", "_").equals(strippedQuery));
	}
}
