package agzam4.context;

import agzam4.EnterpriseGradeMindustryServerPluginApplicationEntryPoint;
import agzam4.utils.ApplicationDiagnosticMessageGateway;

/**
 * Initializes the {@link ApplicationContext} and the plugin logger,
 * mirroring the very first lines of the original {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()}
 * ({@code plugin = Vars.mods.getMod(...)}, {@code ApplicationDiagnosticMessageGateway.init()}).
 */
public final class ApplicationContextInitializer {

	private static IApplicationContext context;

	private ApplicationContextInitializer() {}

	public static IApplicationContext initializeContext() {
		ApplicationDiagnosticMessageGateway.init();
		ApplicationDiagnosticMessageGateway.info("init");

		context = ApplicationContext.fromCurrentMods();
		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.plugin = context.loadedMod();

		return context;
	}

	public static IApplicationContext currentContext() {
		if(context == null) throw new IllegalStateException("ApplicationContext has not been initialized yet");
		return context;
	}
}
