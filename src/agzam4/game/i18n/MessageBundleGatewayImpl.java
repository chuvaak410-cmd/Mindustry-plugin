package agzam4.game.i18n;

import arc.util.Strings;
import mindustry.ctype.MappableContent;

/** Default {@link IMessageBundleGateway}, mirroring the original {@code MindustryGameRuntimeFacade} bundle-lookup logic exactly. */
public class MessageBundleGatewayImpl implements IMessageBundleGateway {

	private final IMessageBundleLoaderService loader = MessageBundleLoaderServiceImpl.instance();

	@Override
	public String bungle(String string) {
		return loader.bundle().get(string, "[red]???" + string + "???[]");
	}

	@Override
	public String bungleDef(String string, String def) {
		return loader.bundle().get(string, def);
	}

	@Override
	public String bungle(String text, Object... args) {
		return bungle(Strings.format(text, args));
	}

	@Override
	public String contentName(MappableContent content) {
		return loader.bundle().get("content." + content.name, "[red]???" + content.name + "???[]");
	}
}
