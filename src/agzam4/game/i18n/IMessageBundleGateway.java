package agzam4.game.i18n;

import mindustry.ctype.MappableContent;

/**
 * Lookup facade over the loaded {@code I18NBundle}, mirroring
 * {@code MindustryGameRuntimeFacade.bungle}/{@code bungleDef}/{@code contentName} exactly.
 */
public interface IMessageBundleGateway {

	String bungle(String string);

	String bungleDef(String string, String def);

	String bungle(String text, Object... args);

	String contentName(MappableContent content);
}
