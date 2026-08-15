package agzam4.provider;

import arc.graphics.Color;
import mindustry.game.Team;

/** Delegating contract over the static {@link agzam4.game.MindustryGameRuntimeFacade} facade. */
public interface IGameProvider {

	void initialize();

	Team defaultTeam();

	String colorToHex(Color color);
}
