package agzam4.bot.registry;

import agzam4.bot.TChat;
import agzam4.bot.TUser;
import arc.struct.LongMap;

/**
 * Singleton default {@link ITelegramBotRegistry}. Owns the same
 * {@code LongMap<TChat>}/{@code LongMap<TUser>} instances that used to be
 * the public static {@code chats}/{@code users} fields on
 * {@link agzam4.bot.TelegramBot} - {@code TelegramBot} still exposes those
 * fields (assigned from here) so every existing call site keeps mutating
 * the very same maps.
 */
public final class TelegramBotRegistry implements ITelegramBotRegistry {

	private static final TelegramBotRegistry INSTANCE = new TelegramBotRegistry();

	private final LongMap<TChat> chats = new LongMap<>();
	private final LongMap<TUser> users = new LongMap<>();

	private TelegramBotRegistry() {}

	public static TelegramBotRegistry instance() {
		return INSTANCE;
	}

	@Override
	public LongMap<TChat> chats() {
		return chats;
	}

	@Override
	public LongMap<TUser> users() {
		return users;
	}
}
