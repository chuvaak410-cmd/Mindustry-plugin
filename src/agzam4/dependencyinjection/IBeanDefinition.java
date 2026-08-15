package agzam4.dependencyinjection;

/**
 * Metadata describing how a bean of a given type is produced and cached
 * inside the {@link IBeanFactory}.
 */
public interface IBeanDefinition<T> {

	Class<T> beanType();

	IBeanProvider<T> beanProvider();
}
