package agzam4.bot.strategy;

import arc.struct.ObjectSet;

/**
 * The permission-check branching logic that used to live directly on
 * {@link agzam4.bot.TSender} ({@code hasPermission}, {@code hasPermissionKey},
 * {@code hasChatPermissionKey}, {@code hasOnlyChatPermission}). Operates on
 * the sender's own permission set, passed in unchanged.
 */
public interface ITSenderPermissionStrategy {

	boolean hasPermissionKey(ObjectSet<String> permissions, String key);

	boolean hasChatPermissionKey(ObjectSet<String> permissions, String key);

	boolean hasPermission(ObjectSet<String> permissions, String permission);

	boolean hasOnlyChatPermission(ObjectSet<String> permissions, String permission);
}
