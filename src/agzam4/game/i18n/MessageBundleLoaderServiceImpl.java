package agzam4.game.i18n;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import arc.struct.ObjectMap;
import arc.util.I18NBundle;
import arc.util.io.PropertiesUtils;

/**
 * Singleton default {@link IMessageBundleLoaderService}. {@link #init()} is
 * the exact body of the original {@code MindustryGameRuntimeFacade.init()}: creates an empty
 * bundle, loads {@code /bundles/bundle.properties} as UTF-8 properties, and
 * swallows {@link UnsupportedEncodingException} via
 * {@code printStackTrace()} just as before.
 */
public final class MessageBundleLoaderServiceImpl implements IMessageBundleLoaderService {

	private static final MessageBundleLoaderServiceImpl INSTANCE = new MessageBundleLoaderServiceImpl();

	private I18NBundle bundle;

	private MessageBundleLoaderServiceImpl() {}

	public static MessageBundleLoaderServiceImpl instance() {
		return INSTANCE;
	}

	@Override
	public void init() {
		bundle = I18NBundle.createEmptyBundle();
		try {
			ObjectMap<String, String> properties = new ObjectMap<>();
			PropertiesUtils.load(properties, new InputStreamReader(MessageBundleLoaderServiceImpl.class.getResourceAsStream("/bundles/bundle.properties"), "UTF-8"));
			bundle.setProperties(properties);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public I18NBundle bundle() {
		return bundle;
	}
}
