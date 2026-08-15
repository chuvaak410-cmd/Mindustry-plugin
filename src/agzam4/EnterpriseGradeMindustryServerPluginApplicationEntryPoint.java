package agzam4;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.Blocks;
import mindustry.entities.units.BuildPlan;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.maps.*;
import mindustry.mod.Mods.LoadedMod;
import mindustry.mod.Plugin;

import agzam4.achievements.*;
import agzam4.admins.Admins;
import agzam4.bot.Bots;
import agzam4.bot.Bots.NotifyTag;
import agzam4.commands.Server;
import agzam4.bot.TelegramBot;
import agzam4.database.Database;
import agzam4.events.EventMap;
import agzam4.events.ServerEventsManager;
import agzam4.managers.PlayerKickOperationOrchestrator;
import agzam4.net.NetMenu;
import agzam4.stats.DataCollecter;
import agzam4.utils.ApplicationDiagnosticMessageGateway;
import agzam4.votes.SkipmapVoteSession;

import static agzam4.utils.UnicodeEmoticonResolutionProvider.*;
import static mindustry.Vars.*;

public class EnterpriseGradeMindustryServerPluginApplicationEntryPoint extends Plugin {
//	Blocks

	public static LoadedMod plugin; 
	
	public static DataCollecter dataCollect;
	public static AchievementsManager achievementsManager;

	public static CommandHandler serverHandler;
	public static CommandHandler clientHandler;
    
    @Override
    public void init() {
    	// Everything the plugin used to do inline here now happens behind
    	// the enterprise bootstrap chain:
    	//   ApplicationLauncherProvider -> ApplicationLauncherFactory
    	//     -> ApplicationBootstrapStrategySelector -> ApplicationBootstrap
    	//       -> ApplicationContextInitializer -> DependencyInjectionBootstrap
    	//         -> ApplicationRuntime (Startup/Runtime lifecycle phases)
    	// See ENTERPRISE_TRANSFORMATION.md for the full mapping back to the
    	// original init() body.
    	agzam4.provider.ApplicationLauncherProvider.defaultProvider()
    		.provideApplicationLauncherFactory()
    		.createApplicationLauncher()
    		.launch();
    }
    
	@Override
    public void registerServerCommands(CommandHandler handler) {
		serverHandler = handler;
    	CommandsManager.flushServerCommands();
    }
    
    @Override
    public void registerClientCommands(CommandHandler handler) {
    	clientHandler = handler;
    	CommandsManager.flushClientCommands();
    }

	public static String name() {
		return plugin.name;
	}

	public static String version() {
		return plugin.meta.version;
	}
}
