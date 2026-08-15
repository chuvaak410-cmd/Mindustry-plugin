package agzam4.database.resolver;

import agzam4.database.Database.PlayerEntity;
import mindustry.gen.Player;

/**
 * Resolves the {@link PlayerEntity} row backing a given in-game
 * {@link Player} or player uuid, creating it on first access exactly as
 * {@link agzam4.database.Database#player} already does.
 */
public interface IPlayerEntityResolver {

	PlayerEntity resolveByPlayer(Player player);

	PlayerEntity resolveByUuid(String uuid);
}
