package agzam4.game.ordnance.strategy;

import mindustry.entities.bullet.BulletType;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;

/** Default {@link IBulletIdResolutionStrategy}, mirroring the original {@code MindustryGameRuntimeFacade} logic exactly. */
public class BulletIdResolutionStrategyImpl implements IBulletIdResolutionStrategy {

	@Override
	public int getPowerTurretBulletId(Block block, int def) {
		if(block instanceof PowerTurret) return ((PowerTurret) block).shootType.id;
		return def;
	}

	@Override
	public int getItemTurretBulletId(Block block, Item item, int def) {
		if(block instanceof ItemTurret) {
			BulletType type = ((ItemTurret) block).ammoTypes.get(item);
			if(type == null) return def;
			return type.id;
		}
		return def;
	}
}
