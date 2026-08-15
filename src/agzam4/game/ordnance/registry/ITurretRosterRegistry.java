package agzam4.game.ordnance.registry;

import mindustry.world.Block;

/**
 * Discoverable seam over the turret roster tables and computed bullet ids
 * that used to be public static fields directly on {@code MindustryGameRuntimeFacade}
 * ({@code serpyloTurrets}, {@code erekirTurrets}, {@code bulletAfflictId},
 * {@code bulletSmiteId}).
 */
public interface ITurretRosterRegistry {

	Block[] serpyloTurrets();

	Block[] erekirTurrets();

	int bulletAfflictId();

	int bulletSmiteId();
}
