package agzam4.commands.pipeline;

import agzam4.commands.factory.ICommandFactory;

/**
 * Validates that the supplied {@link ICommandFactory} is usable before it is
 * allowed to register anything. There is currently nothing to validate
 * beyond null-safety, since command groups are wired at compile time, but
 * the stage exists so future factories (e.g. plugin-supplied ones) have a
 * well-defined place to be rejected.
 */
public class CommandValidationStage implements ICommandRegistrationStage {

	@Override
	public void process(ICommandFactory factory) {
		if(factory == null) throw new IllegalArgumentException("ICommandFactory must not be null");
	}

	@Override
	public String stageName() {
		return "validation";
	}
}
