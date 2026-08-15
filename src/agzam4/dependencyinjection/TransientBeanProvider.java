package agzam4.dependencyinjection;

import arc.func.Prov;

/**
 * A bean provider that constructs a brand new instance on every request.
 */
public class TransientBeanProvider<T> implements IBeanProvider<T> {

	private final Prov<T> factory;

	public TransientBeanProvider(Prov<T> factory) {
		this.factory = factory;
	}

	@Override
	public T provideBean() {
		return factory.get();
	}
}
