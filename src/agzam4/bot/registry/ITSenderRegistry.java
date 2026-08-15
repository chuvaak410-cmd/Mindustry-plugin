package agzam4.bot.registry;

import agzam4.bot.TSender;
import arc.struct.LongMap;

/**
 * Discoverable seam over the static tag -&gt; id -&gt; {@link TSender}
 * registry that used to live directly on {@link TSender} as the private
 * static {@code senders} field.
 */
public interface ITSenderRegistry {

	LongMap<TSender> senders(String tag);

	void put(String tag, TSender sender);

	void remove(String tag, long id);
}
