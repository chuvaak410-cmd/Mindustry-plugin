package agzam4.dependencyinjection;

/**
 * The lightweight dependency injection container contract used by this
 * plugin in place of a heavyweight framework such as Spring. Supports
 * explicit registration of singleton and transient beans as well as
 * resolution by type.
 */
public interface IBeanFactory {

	<T> void registerSingleton(Class<T> type, arc.func.Prov<T> factory);

	<T> void registerTransient(Class<T> type, arc.func.Prov<T> factory);

	<T> T resolve(Class<T> type);

	boolean isRegistered(Class<?> type);
}
