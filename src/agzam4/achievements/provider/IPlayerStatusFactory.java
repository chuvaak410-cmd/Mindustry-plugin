package agzam4.achievements.provider;

import agzam4.achievements.PlayerStatus;

/** Factory contract for constructing {@link PlayerStatus} instances through the provider layer. */
public interface IPlayerStatusFactory {

	PlayerStatus create();
}
