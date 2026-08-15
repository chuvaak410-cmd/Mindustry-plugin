package agzam4.selector;

import agzam4.bootstrap.ApplicationBootstrap;

/**
 * Selects which {@link ApplicationBootstrap} implementation to use. Only one
 * exists today; this selector exists so a hypothetical alternative startup
 * sequence (e.g. a "safe mode" bootstrap) could be introduced without
 * touching {@link agzam4.factory.ApplicationLauncherFactory}.
 */
public class ApplicationBootstrapStrategySelector {

	public ApplicationBootstrap selectBootstrap() {
		return new ApplicationBootstrap();
	}
}
