package agzam4.database.resolver;

import agzam4.database.Database;
import agzam4.database.Database.PlayerEntity;
import mindustry.gen.Player;

/**
 * Default {@link IPlayerEntityResolver}, delegating to the unchanged
 * {@link Database#player} lookups.
 */
public class PlayerEntityResolver implements IPlayerEntityResolver {

	@Override
	public PlayerEntity resolveByPlayer(Player player) {
		return Database.player(player);
	}

	@Override
	public PlayerEntity resolveByUuid(String uuid) {
		return Database.player(uuid);
	}
}
