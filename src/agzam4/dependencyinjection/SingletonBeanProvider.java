package agzam4.dependencyinjection;

import arc.func.Prov;

/**
 * A bean provider that lazily constructs a bean exactly once and returns the
 * same cached instance for every subsequent request.
 */
public class SingletonBeanProvider<T> implements IBeanProvider<T> {

	private final Prov<T> factory;
	private T instance;
	private boolean initialized;

	public SingletonBeanProvider(Prov<T> factory) {
		this.factory = factory;
	}

	@Override
	public synchronized T provideBean() {
		if(!initialized) {
			instance = factory.get();
			initialized = true;
		}
		return instance;
	}
}
