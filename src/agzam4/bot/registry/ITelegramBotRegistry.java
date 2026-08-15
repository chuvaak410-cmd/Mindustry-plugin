package agzam4.bot.registry;

import agzam4.bot.TChat;
import agzam4.bot.TUser;
import arc.struct.LongMap;

/**
 * Discoverable seam over the static {@code chats}/{@code users} maps that
 * used to live directly as public static fields on
 * {@link agzam4.bot.TelegramBot}.
 */
public interface ITelegramBotRegistry {

	LongMap<TChat> chats();

	LongMap<TUser> users();
}
