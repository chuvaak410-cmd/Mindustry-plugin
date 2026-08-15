package agzam4.game.ordnance.selector;

import arc.util.Nullable;
import mindustry.entities.bullet.BulletType;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ContinuousLiquidTurret;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LiquidTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;

/** Default {@link ITurretBulletTypeSelector}, mirroring the original {@code MyBullets} logic exactly. */
public class TurretBulletTypeSelectorImpl implements ITurretBulletTypeSelector {

	@Override
	public @Nullable BulletType getItemBullet(Block itemTurret, Item item) {
		if(!(itemTurret instanceof ItemTurret turret)) return null;
		return turret.ammoTypes.get(item);
	}

	@Override
	public @Nullable BulletType getLiquidBullet(Block turret, Liquid liquid) {
		if(turret instanceof LiquidTurret t) return t.ammoTypes.get(liquid);
		if(turret instanceof ContinuousLiquidTurret t) return t.ammoTypes.get(liquid);
		return null;
	}

	@Override
	public BulletType getLaserBullet(Block turret) {
		if(!(turret instanceof PowerTurret t)) return null;
		return t.shootType;
	}

	@Override
	public BulletType getUnitBullet(UnitType type, int i) {
		return type.weapons.get(i).bullet;
	}
}
