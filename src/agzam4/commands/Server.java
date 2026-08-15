package agzam4.commands;

import agzam4.EnterpriseGradeMindustryServerPluginApplicationEntryPoint;
import arc.Core;
import arc.struct.ObjectSet;
import arc.util.Nullable;

public class Server {
	
	public String name = "сервер";

	public static @Nullable String discordLink;
	public static int doorsCap;
    public static ObjectSet<String> extrastarUids;
	
	@SuppressWarnings("unchecked")
	public static void init() {
		doorsCap = Core.settings.getInt(EnterpriseGradeMindustryServerPluginApplicationEntryPoint.name() + "-doors-cap", Integer.MAX_VALUE);
		discordLink = Core.settings.getString(EnterpriseGradeMindustryServerPluginApplicationEntryPoint.name() + "-discord-link", null);
		extrastarUids = Core.settings.getJson(EnterpriseGradeMindustryServerPluginApplicationEntryPoint.name() + "-extrastar-uids", ObjectSet.class, () -> new ObjectSet<String>());
	}
	
}
