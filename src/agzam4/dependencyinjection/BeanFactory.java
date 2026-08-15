package agzam4.dependencyinjection;

import java.util.HashMap;
import java.util.Map;

import arc.func.Prov;

/**
 * Default {@link IBeanFactory} implementation. Backed by a simple map of
 * {@link IBeanDefinition}s keyed by type, resolved through the
 * {@link DependencyInjectionRegistry}.
 */
public class BeanFactory implements IBeanFactory {

	private final Map<Class<?>, IBeanDefinition<?>> definitions = new HashMap<>();

	@Override
	public <T> void registerSingleton(Class<T> type, Prov<T> factory) {
		definitions.put(type, new BeanDefinition<>(type, new SingletonBeanProvider<>(factory)));
	}

	@Override
	public <T> void registerTransient(Class<T> type, Prov<T> factory) {
		definitions.put(type, new BeanDefinition<>(type, new TransientBeanProvider<>(factory)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T resolve(Class<T> type) {
		IBeanDefinition<?> definition = definitions.get(type);
		if(definition == null) throw new IllegalStateException("No bean registered for type " + type.getName());
		return (T) definition.beanProvider().provideBean();
	}

	@Override
	public boolean isRegistered(Class<?> type) {
		return definitions.containsKey(type);
	}
}
