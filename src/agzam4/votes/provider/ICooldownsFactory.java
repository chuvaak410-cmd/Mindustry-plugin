package agzam4.votes.provider;

import agzam4.votes.Cooldowns;

/** Factory contract mirroring the {@link Cooldowns} constructor. */
public interface ICooldownsFactory {

	<T> Cooldowns<T> create(float seconds);
}
