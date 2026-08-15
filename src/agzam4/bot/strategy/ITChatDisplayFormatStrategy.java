package agzam4.bot.strategy;

import arc.util.Nullable;

/**
 * The display-format branching that used to live directly on
 * {@link agzam4.bot.TChat#toString()} and {@link agzam4.bot.TChat#fuid()}:
 * a multi-thread group, a single thread, or a plain group chat all render
 * differently.
 */
public interface ITChatDisplayFormatStrategy {

	String toDisplayString(int threadsSize, @Nullable Integer thread, String uid);

	String toFuid(@Nullable Integer thread, String baseFuid);
}
