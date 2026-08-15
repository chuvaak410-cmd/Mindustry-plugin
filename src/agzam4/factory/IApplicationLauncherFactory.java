package agzam4.factory;

import agzam4.bootstrap.IApplicationLauncher;

/**
 * Constructs {@link IApplicationLauncher} instances.
 */
public interface IApplicationLauncherFactory {

	IApplicationLauncher createApplicationLauncher();
}
