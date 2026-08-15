package agzam4.managers.provider;

import agzam4.database.Database.PlayerEntity;
import arc.struct.ObjectMap;
import arc.util.Nullable;
import mindustry.gen.Player;

/** Delegating contract over the static {@link agzam4.managers.ActivePlayerCollectionCoordinator} facade. */
public interface IPlayersManagerProvider {

	void initialize();

	int mapPlaytime(Player player);

	int gamePlaytime(Player player);

	@Nullable PlayerEntity joinedEntity(Player player);

	@Nullable PlayerEntity joinedEntity(String uuid);

	ObjectMap<String, PlayerEntity> getJoined();

	int joinedAmount();
}
