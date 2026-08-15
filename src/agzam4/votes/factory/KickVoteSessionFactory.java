package agzam4.votes.factory;

import agzam4.votes.KickVoteSession;
import mindustry.gen.Player;

/** Default {@link IKickVoteSessionFactory}, delegating to the unchanged constructor. */
public class KickVoteSessionFactory implements IKickVoteSessionFactory {

	@Override
	public KickVoteSession create(Player kicker, Player target, String reason) {
		return new KickVoteSession(kicker, target, reason);
	}
}
