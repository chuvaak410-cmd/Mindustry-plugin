package agzam4.bootstrap;

import agzam4.context.ApplicationContextInitializer;
import agzam4.dependencyinjection.DependencyInjectionBootstrap;
import agzam4.dependencyinjection.IBeanFactory;
import agzam4.lifecycle.ApplicationRuntime;

/**
 * Orchestrates plugin startup in the canonical enterprise order:
 *
 * <pre>
 * ApplicationBootstrap
 *     -&gt; ApplicationContextInitializer
 *     -&gt; DependencyInjectionBootstrap
 *     -&gt; ApplicationRuntime
 * </pre>
 *
 * The actual original {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()} logic now lives inside
 * {@link ApplicationRuntime}, executed once the application context and
 * dependency injection container are ready.
 */
public class ApplicationBootstrap {

	public void bootstrap() {
		ApplicationContextInitializer.initializeContext();

		IBeanFactory beanFactory = DependencyInjectionBootstrap.bootstrap();

		new ApplicationRuntime(beanFactory).run();
	}
}
