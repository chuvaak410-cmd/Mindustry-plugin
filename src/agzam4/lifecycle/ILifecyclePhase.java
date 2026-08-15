package agzam4.lifecycle;

/**
 * A single named phase run by the {@link LifecycleCoordinator}.
 */
public interface ILifecyclePhase {

	void run();

	String phaseName();
}
