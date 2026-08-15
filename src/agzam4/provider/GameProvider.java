package agzam4.provider;

import agzam4.game.MindustryGameRuntimeFacade;
import arc.graphics.Color;
import mindustry.game.Team;

/** Default {@link IGameProvider}, delegating to the unchanged {@link MindustryGameRuntimeFacade} statics. */
public class GameProvider implements IGameProvider {

	@Override
	public void initialize() {
		MindustryGameRuntimeFacade.init();
	}

	@Override
	public Team defaultTeam() {
		return MindustryGameRuntimeFacade.defaultTeam();
	}

	@Override
	public String colorToHex(Color color) {
		return MindustryGameRuntimeFacade.colorToHex(color);
	}
}
