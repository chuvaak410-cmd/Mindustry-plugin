package agzam4.provider;

import agzam4.factory.IApplicationLauncherFactory;

/**
 * Supplies the {@link IApplicationLauncherFactory} used to build the
 * {@link agzam4.bootstrap.IApplicationLauncher}.
 */
public interface IApplicationLauncherProvider {

	IApplicationLauncherFactory provideApplicationLauncherFactory();
}
