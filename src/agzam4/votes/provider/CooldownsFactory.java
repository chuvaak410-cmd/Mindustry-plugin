package agzam4.votes.provider;

import agzam4.votes.Cooldowns;

/** Default {@link ICooldownsFactory}, delegating to the unchanged constructor. */
public class CooldownsFactory implements ICooldownsFactory {

	@Override
	public <T> Cooldowns<T> create(float seconds) {
		return new Cooldowns<>(seconds);
	}
}
