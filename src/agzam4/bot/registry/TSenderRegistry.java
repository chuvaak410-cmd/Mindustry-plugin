package agzam4.bot.registry;

import agzam4.bot.TSender;
import arc.struct.LongMap;
import arc.struct.ObjectMap;

/**
 * Singleton default {@link ITSenderRegistry}. Owns the same
 * {@code ObjectMap<String, LongMap<TSender>>} that used to be a private
 * static field on {@link TSender} - the tag -&gt; id -&gt; sender lookup and
 * lazy per-tag map creation are unchanged, just relocated here.
 */
public final class TSenderRegistry implements ITSenderRegistry {

	private static final TSenderRegistry INSTANCE = new TSenderRegistry();

	private final ObjectMap<String, LongMap<TSender>> senders = new ObjectMap<>();

	private TSenderRegistry() {}

	public static TSenderRegistry instance() {
		return INSTANCE;
	}

	@Override
	public LongMap<TSender> senders(String tag) {
		var list = senders.get(tag);
		if(list == null) {
			list = new LongMap<>();
			senders.put(tag, list);
		}
		return list;
	}

	@Override
	public void put(String tag, TSender sender) {
		senders(tag).put(sender.id, sender);
	}

	@Override
	public void remove(String tag, long id) {
		senders(tag).remove(id);
	}
}
