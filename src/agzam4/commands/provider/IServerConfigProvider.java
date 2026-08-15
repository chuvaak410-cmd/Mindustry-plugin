package agzam4.commands.provider;

import arc.struct.ObjectSet;
import arc.util.Nullable;

/** Delegating contract over the static {@link agzam4.commands.Server} config facade. */
public interface IServerConfigProvider {

	void initialize();

	@Nullable String discordLink();

	int doorsCap();

	ObjectSet<String> extrastarUids();
}
