package agzam4.game.player.selector;

import arc.util.Nullable;
import mindustry.gen.Player;

/** Runs the ordered {@code IPlayerLookupStrategy} chain, returning the first non-null hit. */
public interface IPlayerLookupSelector {

	@Nullable Player find(String s);
}
