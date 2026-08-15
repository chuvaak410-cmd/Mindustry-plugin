package agzam4.game.ordnance.selector;

import arc.util.Nullable;
import mindustry.entities.bullet.BulletType;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.UnitType;
import mindustry.world.Block;

/**
 * The four turret/weapon bullet-type lookups that used to live directly on
 * {@code MyBullets} ({@code getItemBullet}, {@code getLiquidBullet},
 * {@code getLaserBullet}, {@code getUnitBullet}), keyed by turret/weapon
 * kind.
 */
public interface ITurretBulletTypeSelector {

	/**
	 * @param itemTurret - block of item turret
	 * @param item - type of ammo
	 * @return null if block not item turret and turret bullet type if found
	 */
	@Nullable BulletType getItemBullet(Block itemTurret, Item item);

	/**
	 * @param turret - block of liquid turret
	 * @param liquid - type of ammo
	 * @return null if block not item turret and turret bullet type if found
	 */
	@Nullable BulletType getLiquidBullet(Block turret, Liquid liquid);

	/**
	 * @param turret - block of liquid turret
	 * @return null if block not item turret and turret bullet type if found
	 */
	BulletType getLaserBullet(Block turret);

	BulletType getUnitBullet(UnitType type, int i);
}
