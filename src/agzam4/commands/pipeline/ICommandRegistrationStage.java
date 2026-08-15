package agzam4.commands.pipeline;

import agzam4.commands.factory.ICommandFactory;

/**
 * A single stage of the {@link CommandRegistrationPipeline}.
 */
public interface ICommandRegistrationStage {

	void process(ICommandFactory factory);

	String stageName();
}
