package agzam4.commands.pipeline;

import agzam4.commands.factory.ICommandFactory;
import arc.struct.Seq;

/**
 * Runs every {@link ICommandFactory} through the fixed sequence of stages:
 * discovery -> validation -> permission-binding -> registration. This
 * replaces the previous approach of {@code CommandsManager.init()} calling
 * {@code registerBotCommands()/registerPlayersCommands()/registerAdminCommands()}
 * directly - those calls now happen as the final ("registration") stage of
 * this pipeline, invoked through the command group factories.
 */
public class CommandRegistrationPipeline {

	private final Seq<ICommandRegistrationStage> stages = Seq.with(
		new CommandDiscoveryStage(),
		new CommandValidationStage(),
		new CommandPermissionBindingStage(),
		new CommandRegistrationStage()
	);

	public void run(Seq<ICommandFactory> commandFactories) {
		for (ICommandFactory factory : commandFactories) {
			for (ICommandRegistrationStage stage : stages) {
				stage.process(factory);
			}
		}
	}
}
