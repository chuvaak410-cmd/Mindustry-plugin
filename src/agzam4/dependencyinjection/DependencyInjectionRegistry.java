package agzam4.dependencyinjection;

/**
 * Holds the single {@link IBeanFactory} instance used across the plugin's
 * runtime. Exists as its own registry so consumers depend on a stable
 * indirection point rather than a concrete {@link BeanFactory}.
 */
public final class DependencyInjectionRegistry {

	private static IBeanFactory beanFactory;

	private DependencyInjectionRegistry() {}

	public static void register(IBeanFactory factory) {
		beanFactory = factory;
	}

	public static IBeanFactory beanFactory() {
		if(beanFactory == null) throw new IllegalStateException("DependencyInjectionRegistry has not been initialized yet");
		return beanFactory;
	}

	public static boolean isInitialized() {
		return beanFactory != null;
	}
}
