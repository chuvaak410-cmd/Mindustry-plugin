package agzam4.votes.factory;

import agzam4.votes.SkipmapVoteSession;

/** Default {@link ISkipmapVoteSessionFactory}, delegating to the unchanged constructor. */
public class SkipmapVoteSessionFactory implements ISkipmapVoteSessionFactory {

	@Override
	public SkipmapVoteSession create() {
		return new SkipmapVoteSession();
	}
}
