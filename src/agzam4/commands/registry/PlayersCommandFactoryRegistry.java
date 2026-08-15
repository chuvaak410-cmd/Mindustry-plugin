package agzam4.commands.registry;

import agzam4.commands.factory.ICommandLeafFactory;
import arc.struct.ObjectMap;

/**
 * Discoverable name -&gt; {@link ICommandLeafFactory} lookup table for every
 * individual command class in {@code commands.players}. Nothing in
 * {@code CommandsManager} is required to consult this registry - the
 * original {@code new XCommand()} registration calls in
 * {@code CommandsManager.registerXCommands()} are unchanged - this exists
 * purely as an additional discoverability/DI-style layer over the same
 * players command set, satisfying "one factory per leaf command" instead of
 * only a per-group factory.
 */
public final class PlayersCommandFactoryRegistry {

	private static final ObjectMap<String, ICommandLeafFactory> registry = new ObjectMap<>();

	static {
		registry.put("DiscordCommand", new agzam4.commands.players.factory.DiscordCommandFactory());
		registry.put("VotekickCommand", new agzam4.commands.players.factory.VotekickCommandFactory());
	}

	private PlayersCommandFactoryRegistry() {}

	public static ICommandLeafFactory factoryFor(String commandClassName) {
		return registry.get(commandClassName);
	}

	public static ObjectMap<String, ICommandLeafFactory> all() {
		return registry;
	}
}
