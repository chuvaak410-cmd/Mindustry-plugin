package agzam4.lifecycle;

import agzam4.dependencyinjection.IBeanFactory;

/**
 * Default {@link IApplicationRuntime}. Drives a {@link LifecycleCoordinator}
 * through startup -> runtime -> shutdown, with {@link StartupLifecyclePhase}
 * and {@link RuntimeLifecyclePhase} together reproducing exactly the body of
 * the original {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()} method.
 */
public class ApplicationRuntime implements IApplicationRuntime {

	private final IBeanFactory beanFactory;

	public ApplicationRuntime(IBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public void run() {
		// Shutdown is intentionally not run here - the Mindustry Plugin API
		// exposes no shutdown hook the original plugin used, so
		// ShutdownLifecyclePhase is registered but only ever invoked if a
		// future integration point calls for it explicitly.
		new LifecycleCoordinator()
			.addPhase(new StartupLifecyclePhase(beanFactory))
			.addPhase(new RuntimeLifecyclePhase())
			.runAllPhases();
	}
}
