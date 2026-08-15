package agzam4.game.ordnance.registry;

import static mindustry.content.Blocks.*;

import agzam4.game.ordnance.strategy.BulletIdResolutionStrategyImpl;
import agzam4.game.ordnance.strategy.IBulletIdResolutionStrategy;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.world.Block;

/**
 * Singleton default {@link ITurretRosterRegistry}. Owns the same
 * {@code serpyloTurrets}/{@code erekirTurrets} arrays moved here verbatim
 * from {@code MindustryGameRuntimeFacade}, and computes {@code bulletAfflictId}/
 * {@code bulletSmiteId} once at construction time via
 * {@link IBulletIdResolutionStrategy}, matching the original
 * {@code static final} initializers.
 */
public final class TurretRosterRegistry implements ITurretRosterRegistry {

	private static final TurretRosterRegistry INSTANCE = new TurretRosterRegistry();

	private final Block[] serpyloTurrets = {duo, scatter, scorch, hail, arc, wave, lancer, swarmer, salvo, fuse, ripple, cyclone,
			foreshadow, spectre, meltdown, segment, parallax, tsunami
	};

	private final Block[] erekirTurrets = {breach, diffuse, sublimate, titan, disperse, afflict, lustre, scathe, smite, malign};

	private final int bulletAfflictId;
	private final int bulletSmiteId;

	private TurretRosterRegistry() {
		IBulletIdResolutionStrategy strategy = new BulletIdResolutionStrategyImpl();
		bulletAfflictId = strategy.getPowerTurretBulletId(Blocks.afflict, 165);
		bulletSmiteId = strategy.getItemTurretBulletId(Blocks.smite, Items.surgeAlloy, 171);
	}

	public static TurretRosterRegistry instance() {
		return INSTANCE;
	}

	@Override
	public Block[] serpyloTurrets() {
		return serpyloTurrets;
	}

	@Override
	public Block[] erekirTurrets() {
		return erekirTurrets;
	}

	@Override
	public int bulletAfflictId() {
		return bulletAfflictId;
	}

	@Override
	public int bulletSmiteId() {
		return bulletSmiteId;
	}
}
