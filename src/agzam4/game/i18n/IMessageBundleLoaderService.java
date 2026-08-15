package agzam4.game.i18n;

import arc.util.I18NBundle;

/**
 * Owns loading of the plugin's {@code /bundles/bundle.properties} resource
 * into an {@link I18NBundle}, mirroring what used to be
 * {@code MindustryGameRuntimeFacade.init()} plus its private static {@code bundle} field.
 */
public interface IMessageBundleLoaderService {

	void init();

	I18NBundle bundle();
}
