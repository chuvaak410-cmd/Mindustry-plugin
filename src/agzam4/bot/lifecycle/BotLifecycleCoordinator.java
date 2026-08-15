package agzam4.bot.lifecycle;

import agzam4.bot.provider.BotSessionProvider;
import agzam4.bot.provider.IBotSessionProvider;
import agzam4.utils.ApplicationDiagnosticMessageGateway;

/**
 * Default {@link IBotLifecycleCoordinator}. Starting the bot session
 * preserves the original try/catch-and-log behaviour that used to live
 * directly inside {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()}: a failure to start the bot
 * must not prevent the rest of the plugin from initializing.
 */
public class BotLifecycleCoordinator implements IBotLifecycleCoordinator {

	private final IBotSessionProvider botSessionProvider = new BotSessionProvider();

	@Override
	public void startBotSession() {
		try {
			botSessionProvider.provideBotSessionFactory().createAndStartSession();
		} catch (Exception e) {
			ApplicationDiagnosticMessageGateway.err(e);
		}
	}
}
