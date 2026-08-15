package agzam4.commands.registry;

import agzam4.commands.factory.ICommandLeafFactory;
import arc.struct.ObjectMap;

/**
 * Discoverable name -&gt; {@link ICommandLeafFactory} lookup table for every
 * individual command class in {@code commands.server}. Nothing in
 * {@code CommandsManager} is required to consult this registry - the
 * original {@code new XCommand()} registration calls in
 * {@code CommandsManager.registerXCommands()} are unchanged - this exists
 * purely as an additional discoverability/DI-style layer over the same
 * server command set, satisfying "one factory per leaf command" instead of
 * only a per-group factory.
 */
public final class ServerCommandFactoryRegistry {

	private static final ObjectMap<String, ICommandLeafFactory> registry = new ObjectMap<>();

	static {
		registry.put("AsCommand", new agzam4.commands.server.factory.AsCommandFactory());
		registry.put("BansCommand", new agzam4.commands.server.factory.BansCommandFactory());
		registry.put("ChatfilterCommand", new agzam4.commands.server.factory.ChatfilterCommandFactory());
		registry.put("ConfigCommand", new agzam4.commands.server.factory.ConfigCommandFactory());
		registry.put("DoorscapCommand", new agzam4.commands.server.factory.DoorscapCommandFactory());
		registry.put("EventCommand", new agzam4.commands.server.factory.EventCommandFactory());
		registry.put("ExtrastarCommand", new agzam4.commands.server.factory.ExtrastarCommandFactory());
		registry.put("FillitemsCommand", new agzam4.commands.server.factory.FillitemsCommandFactory());
		registry.put("HelperCommand", new agzam4.commands.server.factory.HelperCommandFactory());
		registry.put("InfoCommand", new agzam4.commands.server.factory.InfoCommandFactory());
		registry.put("JsCommand", new agzam4.commands.server.factory.JsCommandFactory());
		registry.put("LinkCommand", new agzam4.commands.server.factory.LinkCommandFactory());
		registry.put("NextmapCommand", new agzam4.commands.server.factory.NextmapCommandFactory());
		registry.put("ReloadmapsCommand", new agzam4.commands.server.factory.ReloadmapsCommandFactory());
		registry.put("RestartCommand", new agzam4.commands.server.factory.RestartCommandFactory());
		registry.put("RunwaveCommand", new agzam4.commands.server.factory.RunwaveCommandFactory());
		registry.put("SandboxCommand", new agzam4.commands.server.factory.SandboxCommandFactory());
		registry.put("SetcustomCommand", new agzam4.commands.server.factory.SetcustomCommandFactory());
		registry.put("SetdiscordCommand", new agzam4.commands.server.factory.SetdiscordCommandFactory());
		registry.put("SetnickCommand", new agzam4.commands.server.factory.SetnickCommandFactory());
		registry.put("StatCommand", new agzam4.commands.server.factory.StatCommandFactory());
		registry.put("TeamCommand", new agzam4.commands.server.factory.TeamCommandFactory());
		registry.put("ThreadsCommand", new agzam4.commands.server.factory.ThreadsCommandFactory());
		registry.put("UnbanCommand", new agzam4.commands.server.factory.UnbanCommandFactory());
	}

	private ServerCommandFactoryRegistry() {}

	public static ICommandLeafFactory factoryFor(String commandClassName) {
		return registry.get(commandClassName);
	}

	public static ObjectMap<String, ICommandLeafFactory> all() {
		return registry;
	}
}
