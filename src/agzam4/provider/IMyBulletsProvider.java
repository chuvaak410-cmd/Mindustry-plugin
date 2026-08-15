package agzam4.provider;

import arc.util.Nullable;
import mindustry.entities.bullet.BulletType;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.UnitType;
import mindustry.world.Block;

/** Delegating contract over the static {@link agzam4.game.MyBullets} lookups. */
public interface IMyBulletsProvider {

	@Nullable BulletType getItemBullet(Block itemTurret, Item item);

	@Nullable BulletType getLiquidBullet(Block turret, Liquid liquid);

	BulletType getLaserBullet(Block turret);

	BulletType getUnitBullet(UnitType type, int i);
}
