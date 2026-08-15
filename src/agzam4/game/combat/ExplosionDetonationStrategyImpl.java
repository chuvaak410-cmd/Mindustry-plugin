package agzam4.game.combat;

import mindustry.gen.Call;
import mindustry.game.Team;

/** Default {@link IExplosionDetonationStrategy}, mirroring the original {@code MindustryGameRuntimeFacade} logic exactly. */
public class ExplosionDetonationStrategyImpl implements IExplosionDetonationStrategy {

	@Override
	public void explosion(Team team, float x, float y, float radius, float damage, boolean ground, boolean air, boolean pierce) {
		Call.logicExplosion(team, x, y, radius, damage, air, ground, pierce, false);
	}
}
