package agzam4.commands.pipeline;

import agzam4.commands.factory.ICommandFactory;
import agzam4.utils.ApplicationDiagnosticMessageGateway;

/**
 * First pipeline stage: simply announces which command group factory is
 * about to be processed. Discovery here is trivial because the factory list
 * is supplied explicitly by {@link agzam4.commands.registry.CommandRegistrationBootstrap},
 * but the stage exists so the pipeline shape matches the rest of the
 * enterprise architecture (discovery -> validation -> permission-binding ->
 * registration).
 */
public class CommandDiscoveryStage implements ICommandRegistrationStage {

	@Override
	public void process(ICommandFactory factory) {
		ApplicationDiagnosticMessageGateway.info("[CommandRegistrationPipeline] discovered command group: @", factory.commandGroupName());
	}

	@Override
	public String stageName() {
		return "discovery";
	}
}
