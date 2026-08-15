package agzam4.commands.pipeline;

import agzam4.commands.factory.ICommandFactory;

/**
 * Final pipeline stage: actually invokes the factory, causing it to register
 * its commands into {@link agzam4.CommandsManager}.
 */
public class CommandRegistrationStage implements ICommandRegistrationStage {

	@Override
	public void process(ICommandFactory factory) {
		factory.createAndRegisterCommands();
	}

	@Override
	public String stageName() {
		return "registration";
	}
}
