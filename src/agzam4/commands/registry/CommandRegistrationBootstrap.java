package agzam4.commands.registry;

import agzam4.commands.factory.AdminCommandGroupFactory;
import agzam4.commands.factory.BotCommandGroupFactory;
import agzam4.commands.factory.ICommandFactory;
import agzam4.commands.factory.PlayerCommandGroupFactory;
import agzam4.commands.pipeline.CommandRegistrationPipeline;
import agzam4.commands.selector.CommandExecutionStrategySelector;
import arc.struct.Seq;

/**
 * Wires together every {@link ICommandFactory}, runs them through the
 * {@link CommandRegistrationPipeline}, and exposes the {@link ICommandRegistry}
 * and flush strategy used afterwards. This is the single entry point
 * {@link agzam4.CommandsManager#init()} now delegates to for command
 * registration, preserving the exact original registration order
 * (bot -> player -> admin).
 */
public final class CommandRegistrationBootstrap {

	private CommandRegistrationBootstrap() {}

	public static ICommandRegistry bootstrapCommandRegistration() {
		Seq<ICommandFactory> commandFactories = Seq.with(
			new BotCommandGroupFactory(),
			new PlayerCommandGroupFactory(),
			new AdminCommandGroupFactory()
		);

		new CommandRegistrationPipeline().run(commandFactories);

		return new CommandRegistry();
	}

	public static void flushUsingSelectedStrategy(ICommandRegistry registry) {
		new CommandExecutionStrategySelector().selectStrategy().execute(registry::flushAll);
	}
}
