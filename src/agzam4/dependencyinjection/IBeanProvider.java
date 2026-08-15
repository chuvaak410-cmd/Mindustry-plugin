package agzam4.dependencyinjection;

import arc.func.Prov;

/**
 * Contract for a component responsible for supplying a single bean instance
 * on demand, according to whatever lifecycle policy the implementation applies
 * (singleton, transient, scoped, ...).
 */
public interface IBeanProvider<T> {

	T provideBean();

	static <T> IBeanProvider<T> ofSupplier(Prov<T> supplier) {
		return supplier::get;
	}
}
