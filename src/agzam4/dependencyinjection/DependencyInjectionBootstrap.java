package agzam4.dependencyinjection;

import agzam4.achievements.provider.AchievementsManagerProvider;
import agzam4.achievements.provider.IAchievementsManagerProvider;
import agzam4.admins.provider.AdminsProvider;
import agzam4.admins.provider.IAdminsProvider;
import agzam4.bot.BotSessionCoordinatorAccess;
import agzam4.commands.provider.IServerConfigProvider;
import agzam4.commands.provider.ServerConfigProvider;
import agzam4.commands.registry.CommandRegistry;
import agzam4.commands.registry.ICommandRegistry;
import agzam4.database.provider.DatabaseConnectionProvider;
import agzam4.database.provider.IDatabaseConnectionProvider;
import agzam4.events.provider.EventSubsystemProvider;
import agzam4.events.provider.IEventSubsystemProvider;
import agzam4.managers.provider.IKicksProvider;
import agzam4.managers.provider.KicksProvider;
import agzam4.net.provider.INetMenuProvider;
import agzam4.net.provider.NetMenuProvider;
import agzam4.provider.GameProvider;
import agzam4.provider.IGameProvider;
import agzam4.provider.IPlayersDataProvider;
import agzam4.provider.PlayersDataProvider;

/**
 * Bootstraps the plugin's dependency injection container by registering the
 * core infrastructure beans used by every other subsystem. This runs early
 * in the {@link agzam4.bootstrap.ApplicationBootstrap} sequence, right after
 * the {@link agzam4.context.ApplicationContextInitializer}.
 */
public final class DependencyInjectionBootstrap {

	private DependencyInjectionBootstrap() {}

	public static IBeanFactory bootstrap() {
		BeanFactory factory = new BeanFactory();

		factory.registerSingleton(ICommandRegistry.class, CommandRegistry::new);
		factory.registerSingleton(IDatabaseConnectionProvider.class, DatabaseConnectionProvider::new);
		factory.registerSingleton(IEventSubsystemProvider.class, EventSubsystemProvider::new);
		factory.registerSingleton(BotSessionCoordinatorAccess.class, BotSessionCoordinatorAccess::new);
		factory.registerSingleton(IServerConfigProvider.class, ServerConfigProvider::new);
		factory.registerSingleton(IGameProvider.class, GameProvider::new);
		factory.registerSingleton(IAdminsProvider.class, AdminsProvider::new);
		factory.registerSingleton(IPlayersDataProvider.class, PlayersDataProvider::new);
		factory.registerSingleton(IAchievementsManagerProvider.class, AchievementsManagerProvider::new);
		factory.registerSingleton(INetMenuProvider.class, NetMenuProvider::new);
		factory.registerSingleton(IKicksProvider.class, KicksProvider::new);

		DependencyInjectionRegistry.register(factory);
		return factory;
	}
}
