package agzam4.bot.strategy;

import arc.util.Nullable;
import arc.util.Strings;

/** Default {@link ITChatDisplayFormatStrategy}, mirroring the original {@code TChat} logic exactly. */
public class TChatDisplayFormatStrategyImpl implements ITChatDisplayFormatStrategy {

	@Override
	public String toDisplayString(int threadsSize, @Nullable Integer thread, String uid) {
		if(threadsSize > 0) return Strings.format("Mutichat-@ (@ threads)", uid, threadsSize);
		if(thread != null) return Strings.format("Thread-@/@", uid, Integer.toUnsignedString(thread, Character.MAX_RADIX));
		return Strings.format("Group-@", uid);
	}

	@Override
	public String toFuid(@Nullable Integer thread, String baseFuid) {
		if(thread == null) return baseFuid;
		return baseFuid + "/" + Integer.toUnsignedString(thread, Character.MAX_RADIX);
	}
}
