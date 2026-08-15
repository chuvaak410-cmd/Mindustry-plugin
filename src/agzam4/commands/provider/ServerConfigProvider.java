package agzam4.commands.provider;

import agzam4.commands.Server;
import arc.struct.ObjectSet;
import arc.util.Nullable;

/** Default {@link IServerConfigProvider}, delegating to the unchanged {@link Server} statics. */
public class ServerConfigProvider implements IServerConfigProvider {

	@Override
	public void initialize() {
		Server.init();
	}

	@Override
	public @Nullable String discordLink() {
		return Server.discordLink;
	}

	@Override
	public int doorsCap() {
		return Server.doorsCap;
	}

	@Override
	public ObjectSet<String> extrastarUids() {
		return Server.extrastarUids;
	}
}
