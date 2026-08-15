package agzam4.achievements.provider;

import agzam4.achievements.PlayerStatus;

/** Default {@link IPlayerStatusFactory}, delegating to the unchanged {@code new PlayerStatus()}. */
public class PlayerStatusFactory implements IPlayerStatusFactory {

	@Override
	public PlayerStatus create() {
		return new PlayerStatus();
	}
}
