package agzam4.commands.factory;

import agzam4.commands.CommandHandler;

/**
 * Produces a single {@link CommandHandler} leaf instance. One concrete
 * implementation exists per {@code *Command} class so each leaf command is
 * discoverable/constructible through the factory layer instead of being
 * {@code new}-ed inline inside {@code CommandsManager}.
 */
public interface ICommandLeafFactory {

	CommandHandler<?> createCommand();

	String commandName();
}
