package agzam4.lifecycle;

/**
 * Placeholder shutdown phase. The original plugin never performed explicit
 * shutdown work (Mindustry's {@code Plugin} API has no {@code shutdown()}
 * hook that was used here), so this phase intentionally does nothing - it
 * exists purely to complete the startup/runtime/shutdown lifecycle shape.
 */
public class ShutdownLifecyclePhase implements ILifecyclePhase {

	@Override
	public void run() {
		// no shutdown behaviour existed in the original plugin
	}

	@Override
	public String phaseName() {
		return "shutdown";
	}
}
