package agzam4.game.ordnance.strategy;

import mindustry.type.Item;
import mindustry.world.Block;

/**
 * The turret-bullet-id lookup logic that used to be
 * {@code MindustryGameRuntimeFacade.getPowerTurretBulletId}/{@code MindustryGameRuntimeFacade.geItemTurretBulletId}
 * (private helpers used only to compute {@code bulletAfflictId}/
 * {@code bulletSmiteId} once). Method names are spelled correctly here -
 * the originals were {@code private}, so nothing outside {@code MindustryGameRuntimeFacade}
 * depended on the misspelling.
 */
public interface IBulletIdResolutionStrategy {

	int getPowerTurretBulletId(Block block, int def);

	int getItemTurretBulletId(Block block, Item item, int def);
}
