package agzam4.bot.strategy;

import agzam4.bot.TChat;
import agzam4.bot.TUser;
import arc.struct.LongMap;

/** Default {@link ITelegramMessageRoutingStrategy}, mirroring the original {@code TelegramBot.onUpdateReceived} branching exactly. */
public class TelegramMessageRoutingStrategyImpl implements ITelegramMessageRoutingStrategy {

	@Override
	public RoutingDecision route(TUser user, LongMap<TChat> chats, long chatId, long fromId, Integer threadId) {
		if(chatId == fromId) {
			return RoutingDecision.of(Kind.SELF, user);
		}

		var chat = chats.get(chatId);

		if(threadId == null) {
			if(chat == null) return RoutingDecision.of(Kind.CHAT_NOT_FOUND, null);
			return RoutingDecision.of(Kind.CHAT, chat);
		}

		if(chat == null) return RoutingDecision.of(Kind.CHAT_NOT_FOUND, null);
		var thread = chat.thread(threadId);
		if(thread == null) return RoutingDecision.of(Kind.THREAD_NOT_FOUND, null);
		return RoutingDecision.of(Kind.THREAD, thread);
	}
}
