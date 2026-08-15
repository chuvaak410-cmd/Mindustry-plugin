package agzam4.lifecycle;

import agzam4.utils.ApplicationDiagnosticMessageGateway;
import arc.struct.Seq;

/**
 * Runs an ordered set of {@link ILifecyclePhase}s (startup -> runtime ->
 * shutdown) sequentially, logging each transition. {@link ApplicationRuntime}
 * uses this to run its {@code StartupLifecyclePhase} and
 * {@code RuntimeLifecyclePhase}; a shutdown phase is registered for
 * completeness even though the Mindustry plugin API does not currently
 * invoke an explicit shutdown hook.
 */
public class LifecycleCoordinator {

	private final Seq<ILifecyclePhase> phases = new Seq<>();

	public LifecycleCoordinator addPhase(ILifecyclePhase phase) {
		phases.add(phase);
		return this;
	}

	public void runAllPhases() {
		for (ILifecyclePhase phase : phases) {
			ApplicationDiagnosticMessageGateway.info("[LifecycleCoordinator] entering phase: @", phase.phaseName());
			phase.run();
		}
	}
}
