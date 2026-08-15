package agzam4.votes.selector;

import agzam4.votes.factory.IKickVoteSessionFactory;
import agzam4.votes.factory.ISkipmapVoteSessionFactory;
import agzam4.votes.factory.KickVoteSessionFactory;
import agzam4.votes.factory.SkipmapVoteSessionFactory;

/**
 * Selects the appropriate vote-session factory for a given
 * {@link VoteSessionType}. Both {@link agzam4.votes.KickVoteSession} and
 * {@link agzam4.votes.SkipmapVoteSession} keep their original constructors
 * and semantics - this only adds a discoverable seam for "which vote
 * session type" that previously existed only implicitly at call sites.
 */
public class VoteSessionFactorySelector {

	private final IKickVoteSessionFactory kickVoteSessionFactory = new KickVoteSessionFactory();
	private final ISkipmapVoteSessionFactory skipmapVoteSessionFactory = new SkipmapVoteSessionFactory();

	public IKickVoteSessionFactory kickFactory() {
		return kickVoteSessionFactory;
	}

	public ISkipmapVoteSessionFactory skipmapFactory() {
		return skipmapVoteSessionFactory;
	}

	public Object factoryFor(VoteSessionType type) {
		return switch (type) {
			case KICK -> kickVoteSessionFactory;
			case SKIPMAP -> skipmapVoteSessionFactory;
		};
	}
}
