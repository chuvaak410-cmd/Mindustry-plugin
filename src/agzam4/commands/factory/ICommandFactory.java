package agzam4.commands.factory;

/**
 * Contract for a factory responsible for constructing and registering a
 * cohesive group of commands (e.g. all admin commands, all server commands)
 * into {@link agzam4.CommandsManager}. Implementations are pure adapters
 * over the pre-existing {@code CommandsManager.registerXCommands()} methods
 * so that registration is expressed as discrete, discoverable factory units
 * instead of a single monolithic init routine.
 */
public interface ICommandFactory {

	/**
	 * Constructs and registers this factory's group of commands.
	 */
	void createAndRegisterCommands();

	/**
	 * Human readable name of the command group this factory produces,
	 * used purely for logging/diagnostics.
	 */
	String commandGroupName();
}
