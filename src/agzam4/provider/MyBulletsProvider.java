package agzam4.provider;

import agzam4.game.MyBullets;
import arc.util.Nullable;
import mindustry.entities.bullet.BulletType;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.UnitType;
import mindustry.world.Block;

/** Default {@link IMyBulletsProvider}, delegating to the unchanged {@link MyBullets} statics. */
public class MyBulletsProvider implements IMyBulletsProvider {

	@Override
	public @Nullable BulletType getItemBullet(Block itemTurret, Item item) {
		return MyBullets.getItemBullet(itemTurret, item);
	}

	@Override
	public @Nullable BulletType getLiquidBullet(Block turret, Liquid liquid) {
		return MyBullets.getLiquidBullet(turret, liquid);
	}

	@Override
	public BulletType getLaserBullet(Block turret) {
		return MyBullets.getLaserBullet(turret);
	}

	@Override
	public BulletType getUnitBullet(UnitType type, int i) {
		return MyBullets.getUnitBullet(type, i);
	}
}
