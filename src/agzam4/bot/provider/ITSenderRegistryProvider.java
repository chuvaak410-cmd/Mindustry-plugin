package agzam4.bot.provider;

import agzam4.bot.TSender;
import arc.struct.LongMap;

/** Delegating contract over the static {@link TSender} lookup helpers. */
public interface ITSenderRegistryProvider {

	LongMap<TSender> senders(String tag);

	long idOf(String uid);
}
