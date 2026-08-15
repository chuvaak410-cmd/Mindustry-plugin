package agzam4.managers.provider;

import agzam4.database.Database.PlayerEntity;
import agzam4.managers.ActivePlayerCollectionCoordinator;
import arc.struct.ObjectMap;
import arc.util.Nullable;
import mindustry.gen.Player;

/** Default {@link IPlayersManagerProvider}, delegating to the unchanged {@link ActivePlayerCollectionCoordinator} statics. */
public class PlayersManagerProvider implements IPlayersManagerProvider {

	@Override
	public void initialize() {
		ActivePlayerCollectionCoordinator.init();
	}

	@Override
	public int mapPlaytime(Player player) {
		return ActivePlayerCollectionCoordinator.mapPlaytime(player);
	}

	@Override
	public int gamePlaytime(Player player) {
		return ActivePlayerCollectionCoordinator.gamePlaytime(player);
	}

	@Override
	public @Nullable PlayerEntity joinedEntity(Player player) {
		return ActivePlayerCollectionCoordinator.joinedEntity(player);
	}

	@Override
	public @Nullable PlayerEntity joinedEntity(String uuid) {
		return ActivePlayerCollectionCoordinator.joinedEntity(uuid);
	}

	@Override
	public ObjectMap<String, PlayerEntity> getJoined() {
		return ActivePlayerCollectionCoordinator.getJoined();
	}

	@Override
	public int joinedAmount() {
		return ActivePlayerCollectionCoordinator.joinedAmount();
	}
}
