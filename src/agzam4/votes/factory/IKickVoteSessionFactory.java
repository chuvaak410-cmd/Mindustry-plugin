package agzam4.votes.factory;

import agzam4.votes.KickVoteSession;
import mindustry.gen.Player;

/** Factory contract mirroring the {@link KickVoteSession} constructor. */
public interface IKickVoteSessionFactory {

	KickVoteSession create(Player kicker, Player target, String reason);
}
