package agzam4.votes.factory;

import agzam4.votes.SkipmapVoteSession;

/** Factory contract mirroring the {@link SkipmapVoteSession} constructor. */
public interface ISkipmapVoteSessionFactory {

	SkipmapVoteSession create();
}
