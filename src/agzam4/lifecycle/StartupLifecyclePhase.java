package agzam4.lifecycle;

import agzam4.EnterpriseGradeMindustryServerPluginApplicationEntryPoint;
import agzam4.achievements.AchievementsManager;
import agzam4.achievements.provider.IAchievementsManagerProvider;
import agzam4.CommandsManager;
import agzam4.stats.DataCollecter;
import agzam4.admins.provider.IAdminsProvider;
import agzam4.bot.BotSessionCoordinatorAccess;
import agzam4.commands.provider.IServerConfigProvider;
import agzam4.database.provider.IDatabaseConnectionProvider;
import agzam4.dependencyinjection.IBeanFactory;
import agzam4.events.provider.IEventSubsystemProvider;
import agzam4.managers.provider.IKicksProvider;
import agzam4.net.provider.INetMenuProvider;
import agzam4.provider.IGameProvider;
import agzam4.provider.IPlayersDataProvider;
import agzam4.utils.ApplicationDiagnosticMessageGateway;
import arc.Core;
import arc.util.Threads;
import mindustry.Vars;
import mindustry.maps.Maps;

/**
 * All one-time subsystem construction that used to happen sequentially at
 * the top of {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()}: database, server command handler,
 * game state, telegram bot, admins/players data, achievements, net menu,
 * command registration, custom event subsystem, kicks, maps and data
 * collection - in the exact original order.
 */
public class StartupLifecyclePhase implements ILifecyclePhase {

	private final IBeanFactory beanFactory;

	public StartupLifecyclePhase(IBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public void run() {
		IDatabaseConnectionProvider databaseConnectionProvider = beanFactory.resolve(IDatabaseConnectionProvider.class);
		try {
			databaseConnectionProvider.initializeConnection(Vars.saveDirectory.absolutePath() + "/database");
		} catch (ClassNotFoundException e) {
			ApplicationDiagnosticMessageGateway.err(e);
			Threads.sleep(10_000);
			Core.app.exit();
		}

		beanFactory.resolve(IServerConfigProvider.class).initialize();
		beanFactory.resolve(IGameProvider.class).initialize();

		beanFactory.resolve(BotSessionCoordinatorAccess.class).lifecycleCoordinator().startBotSession();

		beanFactory.resolve(IAdminsProvider.class).initialize();
		beanFactory.resolve(IPlayersDataProvider.class).initialize();
		beanFactory.resolve(IAchievementsManagerProvider.class).initialize();
		beanFactory.resolve(INetMenuProvider.class).initialize();

		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.achievementsManager = new AchievementsManager();
		CommandsManager.init();
		ApplicationDiagnosticMessageGateway.reset();

		IEventSubsystemProvider eventSubsystemProvider = beanFactory.resolve(IEventSubsystemProvider.class);
		eventSubsystemProvider.initializeEventSubsystem();
		eventSubsystemProvider.loadEventMap();

		CommandsManager.flushBotCommands();

		beanFactory.resolve(IKicksProvider.class).initialize();

		Vars.maps = new Maps();
		Vars.maps.load();

		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.dataCollect = new DataCollecter();
		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.dataCollect.init();
		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.dataCollect.collect();
	}

	@Override
	public String phaseName() {
		return "startup";
	}
}
