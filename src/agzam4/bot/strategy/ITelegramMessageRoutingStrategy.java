package agzam4.bot.strategy;

import agzam4.bot.TChat;
import agzam4.bot.TSender;
import agzam4.bot.TUser;
import arc.struct.LongMap;

/**
 * The message-routing decision that used to live inline inside
 * {@link agzam4.bot.TelegramBot#onUpdateReceived}: given the incoming
 * chat/from/thread ids, decide whether the message is a direct message to
 * the bot, addressed to a known group chat, or to a specific thread inside
 * a group chat - and which cases are "not found". The actual sending of
 * replies stays in {@code TelegramBot}, unchanged.
 */
public interface ITelegramMessageRoutingStrategy {

	enum Kind {
		SELF,
		CHAT,
		CHAT_NOT_FOUND,
		THREAD,
		THREAD_NOT_FOUND
	}

	final class RoutingDecision {

		public final Kind kind;
		public final TSender target;

		private RoutingDecision(Kind kind, TSender target) {
			this.kind = kind;
			this.target = target;
		}

		public static RoutingDecision of(Kind kind, TSender target) {
			return new RoutingDecision(kind, target);
		}
	}

	RoutingDecision route(TUser user, LongMap<TChat> chats, long chatId, long fromId, Integer threadId);
}
