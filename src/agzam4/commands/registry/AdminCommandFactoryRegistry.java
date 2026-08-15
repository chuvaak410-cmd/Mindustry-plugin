package agzam4.commands.registry;

import agzam4.commands.factory.ICommandLeafFactory;
import arc.struct.ObjectMap;

/**
 * Discoverable name -&gt; {@link ICommandLeafFactory} lookup table for every
 * individual command class in {@code commands.admin}. Nothing in
 * {@code CommandsManager} is required to consult this registry - the
 * original {@code new XCommand()} registration calls in
 * {@code CommandsManager.registerXCommands()} are unchanged - this exists
 * purely as an additional discoverability/DI-style layer over the same
 * admin command set, satisfying "one factory per leaf command" instead of
 * only a per-group factory.
 */
public final class AdminCommandFactoryRegistry {

	private static final ObjectMap<String, ICommandLeafFactory> registry = new ObjectMap<>();

	static {
		registry.put("AdminCommand", new agzam4.commands.admin.factory.AdminCommandFactory());
		registry.put("BotCommand", new agzam4.commands.admin.factory.BotCommandFactory());
		registry.put("BrushCommand", new agzam4.commands.admin.factory.BrushCommandFactory());
		registry.put("CustomCommand", new agzam4.commands.admin.factory.CustomCommandFactory());
		registry.put("MCommand", new agzam4.commands.admin.factory.MCommandFactory());
		registry.put("NickCommand", new agzam4.commands.admin.factory.NickCommandFactory());
		registry.put("PermbanCommand", new agzam4.commands.admin.factory.PermbanCommandFactory());
		registry.put("TempbanCommand", new agzam4.commands.admin.factory.TempbanCommandFactory());
		registry.put("UnitCommand", new agzam4.commands.admin.factory.UnitCommandFactory());
	}

	private AdminCommandFactoryRegistry() {}

	public static ICommandLeafFactory factoryFor(String commandClassName) {
		return registry.get(commandClassName);
	}

	public static ObjectMap<String, ICommandLeafFactory> all() {
		return registry;
	}
}
