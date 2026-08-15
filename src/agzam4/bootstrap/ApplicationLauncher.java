package agzam4.bootstrap;

/**
 * Default {@link IApplicationLauncher}. Delegates the actual startup
 * sequence to {@link ApplicationBootstrap}.
 */
public class ApplicationLauncher implements IApplicationLauncher {

	private final ApplicationBootstrap applicationBootstrap;

	public ApplicationLauncher(ApplicationBootstrap applicationBootstrap) {
		this.applicationBootstrap = applicationBootstrap;
	}

	@Override
	public void launch() {
		applicationBootstrap.bootstrap();
	}
}
