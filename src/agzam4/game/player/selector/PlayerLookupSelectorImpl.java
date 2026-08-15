package agzam4.game.player.selector;

import agzam4.game.MindustryGameRuntimeFacade;
import agzam4.game.player.strategy.ExactNameMatchPlayerLookupStrategyImpl;
import agzam4.game.player.strategy.IPlayerLookupStrategy;
import agzam4.game.player.strategy.StrippedNameMatchPlayerLookupStrategyImpl;
import agzam4.game.player.strategy.StrippedUnderscoreNameMatchPlayerLookupStrategyImpl;
import agzam4.game.player.strategy.UuidMatchPlayerLookupStrategyImpl;
import arc.util.Nullable;
import mindustry.gen.Player;

/**
 * Default {@link IPlayerLookupSelector}, mirroring the original
 * {@code MindustryGameRuntimeFacade.findPlayer(String)} exactly: uuid match, exact name match,
 * a redundant re-check of exact name match against the ORIGINAL query (kept
 * as-is even though it looks dead - not "fixed"), stripped-name match, then
 * stripped-name-with-underscores match. The exact-name strategy instance is
 * reused for both of its appearances in the chain.
 */
public class PlayerLookupSelectorImpl implements IPlayerLookupSelector {

	private final IPlayerLookupStrategy uuidStrategy = new UuidMatchPlayerLookupStrategyImpl();
	private final IPlayerLookupStrategy exactNameStrategy = new ExactNameMatchPlayerLookupStrategyImpl();
	private final IPlayerLookupStrategy strippedNameStrategy = new StrippedNameMatchPlayerLookupStrategyImpl();
	private final IPlayerLookupStrategy strippedUnderscoreNameStrategy = new StrippedUnderscoreNameMatchPlayerLookupStrategyImpl();

	@Override
	public @Nullable Player find(final String s) {
		Player found = uuidStrategy.find(s);
		if(found != null) return found;

		found = exactNameStrategy.find(s);
		if(found != null) return found;

		String strip = MindustryGameRuntimeFacade.strip(s).replaceAll(" ", "_");
		found = exactNameStrategy.find(s);
		if(found != null) return found;
		found = strippedNameStrategy.find(strip);
		if(found != null) return found;
		return strippedUnderscoreNameStrategy.find(strip);
	}
}
