package agzam4.provider;

import agzam4.managers.PlayerData;

/** Factory contract mirroring {@link PlayerData#from(String)}. */
public interface IPlayerDataFactory {

	PlayerData create(String uuid);
}
