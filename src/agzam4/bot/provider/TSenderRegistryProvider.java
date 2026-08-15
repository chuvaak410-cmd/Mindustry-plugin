package agzam4.bot.provider;

import agzam4.bot.TSender;
import arc.struct.LongMap;

/** Default {@link ITSenderRegistryProvider}, delegating to the unchanged {@link TSender} statics. */
public class TSenderRegistryProvider implements ITSenderRegistryProvider {

	@Override
	public LongMap<TSender> senders(String tag) {
		return TSender.senders(tag);
	}

	@Override
	public long idOf(String uid) {
		return TSender.id(uid);
	}
}
