package agzam4.game;

import agzam4.game.ordnance.selector.ITurretBulletTypeSelector;
import agzam4.game.ordnance.selector.TurretBulletTypeSelectorImpl;
import arc.util.Nullable;
import mindustry.entities.bullet.BulletType;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.UnitType;
import mindustry.world.Block;

/**
 * Thin coordinator - every original method signature is preserved, but the
 * actual logic now lives behind {@link ITurretBulletTypeSelector}. See
 * {@code ENTERPRISE_TRANSFORMATION.md} ("Pass 4") for the full breakdown.
 */
public class MyBullets {

	private static final ITurretBulletTypeSelector selector = new TurretBulletTypeSelectorImpl();

	/**
	 * @param itemTurret - block of item turret
	 * @param item - type of ammo
	 * @return null if block not item turret and turret bullet type if found
	 */
	public static @Nullable BulletType getItemBullet(Block itemTurret, Item item) {
		return selector.getItemBullet(itemTurret, item);
	}

	/**
	 * @param turret - block of liquid turret
	 * @param liquid - type of ammo
	 * @return null if block not item turret and turret bullet type if found
	 */
	public static @Nullable BulletType getLiquidBullet(Block turret, Liquid liquid) {
		return selector.getLiquidBullet(turret, liquid);
	}

	/**
	 * @param turret - block of liquid turret
	 * @return null if block not item turret and turret bullet type if found
	 */
	public static BulletType getLaserBullet(Block turret) {
		return selector.getLaserBullet(turret);
	}

	public static BulletType getUnitBullet(UnitType type, int i) {
		return selector.getUnitBullet(type, i);
	}

}
