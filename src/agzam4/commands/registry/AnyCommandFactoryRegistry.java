package agzam4.commands.registry;

import agzam4.commands.factory.ICommandLeafFactory;
import arc.struct.ObjectMap;

/**
 * Discoverable name -&gt; {@link ICommandLeafFactory} lookup table for every
 * individual command class in {@code commands.any}. Nothing in
 * {@code CommandsManager} is required to consult this registry - the
 * original {@code new XCommand()} registration calls in
 * {@code CommandsManager.registerXCommands()} are unchanged - this exists
 * purely as an additional discoverability/DI-style layer over the same
 * any command set, satisfying "one factory per leaf command" instead of
 * only a per-group factory.
 */
public final class AnyCommandFactoryRegistry {

	private static final ObjectMap<String, ICommandLeafFactory> registry = new ObjectMap<>();

	static {
		registry.put("MapinfoCommand", new agzam4.commands.any.factory.MapinfoCommandFactory());
		registry.put("MapsCommand", new agzam4.commands.any.factory.MapsCommandFactory());
		registry.put("SkipmapCommand", new agzam4.commands.any.factory.SkipmapCommandFactory());
		registry.put("SmvoteCommand", new agzam4.commands.any.factory.SmvoteCommandFactory());
		registry.put("VoteCommand", new agzam4.commands.any.factory.VoteCommandFactory());
	}

	private AnyCommandFactoryRegistry() {}

	public static ICommandLeafFactory factoryFor(String commandClassName) {
		return registry.get(commandClassName);
	}

	public static ObjectMap<String, ICommandLeafFactory> all() {
		return registry;
	}
}
