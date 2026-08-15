package agzam4.provider;

import agzam4.factory.ApplicationLauncherFactory;
import agzam4.factory.IApplicationLauncherFactory;

/**
 * Default {@link IApplicationLauncherProvider}. A single default provider
 * instance is exposed via {@link #defaultProvider()}, which is all
 * {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()} needs to reach the rest of the bootstrap chain.
 */
public class ApplicationLauncherProvider implements IApplicationLauncherProvider {

	private static final ApplicationLauncherProvider INSTANCE = new ApplicationLauncherProvider();

	private final IApplicationLauncherFactory applicationLauncherFactory = new ApplicationLauncherFactory();

	public static ApplicationLauncherProvider defaultProvider() {
		return INSTANCE;
	}

	@Override
	public IApplicationLauncherFactory provideApplicationLauncherFactory() {
		return applicationLauncherFactory;
	}
}
