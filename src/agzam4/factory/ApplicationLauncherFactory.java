package agzam4.factory;

import agzam4.bootstrap.ApplicationBootstrap;
import agzam4.bootstrap.ApplicationLauncher;
import agzam4.bootstrap.IApplicationLauncher;
import agzam4.selector.ApplicationBootstrapStrategySelector;

/**
 * Default {@link IApplicationLauncherFactory}. Chooses the
 * {@link ApplicationBootstrap} to use via the
 * {@link ApplicationBootstrapStrategySelector} and wraps it in a fresh
 * {@link ApplicationLauncher}.
 */
public class ApplicationLauncherFactory implements IApplicationLauncherFactory {

	@Override
	public IApplicationLauncher createApplicationLauncher() {
		ApplicationBootstrap bootstrap = new ApplicationBootstrapStrategySelector().selectBootstrap();
		return new ApplicationLauncher(bootstrap);
	}
}
