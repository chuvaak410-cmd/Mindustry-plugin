package agzam4.bot.strategy;

import arc.struct.ObjectSet;

/** Default {@link ITSenderPermissionStrategy}, mirroring the original {@code TSender} logic exactly. */
public class TSenderPermissionStrategyImpl implements ITSenderPermissionStrategy {

	@Override
	public boolean hasPermissionKey(ObjectSet<String> permissions, String key) {
		return permissions.contains(key);
	}

	@Override
	public boolean hasChatPermissionKey(ObjectSet<String> permissions, String key) {
		return permissions.contains("$" + key);
	}

	@Override
	public boolean hasPermission(ObjectSet<String> permissions, String permission) {
		return permissions.contains(permission) || permissions.contains("all");
	}

	@Override
	public boolean hasOnlyChatPermission(ObjectSet<String> permissions, String permission) {
		return permissions.contains("$" + permission) || (permissions.contains("$all") && !permissions.contains(permission));
	}
}
