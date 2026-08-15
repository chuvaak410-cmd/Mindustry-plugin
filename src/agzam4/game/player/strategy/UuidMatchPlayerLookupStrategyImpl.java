package agzam4.game.player.strategy;

import arc.util.Nullable;
import mindustry.gen.Groups;
import mindustry.gen.Player;

/** First step of {@code MindustryGameRuntimeFacade.findPlayer}: exact uuid match. */
public class UuidMatchPlayerLookupStrategyImpl implements IPlayerLookupStrategy {

	@Override
	public @Nullable Player find(String query) {
		return Groups.player.find(p -> p.uuid().equals(query));
	}
}
