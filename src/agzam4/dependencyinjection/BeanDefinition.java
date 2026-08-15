package agzam4.dependencyinjection;

public class BeanDefinition<T> implements IBeanDefinition<T> {

	private final Class<T> beanType;
	private final IBeanProvider<T> beanProvider;

	public BeanDefinition(Class<T> beanType, IBeanProvider<T> beanProvider) {
		this.beanType = beanType;
		this.beanProvider = beanProvider;
	}

	@Override
	public Class<T> beanType() {
		return beanType;
	}

	@Override
	public IBeanProvider<T> beanProvider() {
		return beanProvider;
	}
}
