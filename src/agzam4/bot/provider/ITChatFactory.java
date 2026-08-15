package agzam4.bot.provider;

import agzam4.bot.TChat;

/** Factory contract for constructing {@link TChat} instances by chat id. */
public interface ITChatFactory {

	TChat create(long id);
}
