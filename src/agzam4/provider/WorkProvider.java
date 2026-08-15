package agzam4.provider;

import agzam4.utils.AsynchronousWorkExecutionCoordinator;
import mindustry.type.UnitType;

/** Default {@link IWorkProvider}, delegating to the unchanged {@link AsynchronousWorkExecutionCoordinator} statics. */
public class WorkProvider implements IWorkProvider {

	@Override
	public boolean isPlayerUnit(UnitType unit) {
		return AsynchronousWorkExecutionCoordinator.isPlayerUnit(unit);
	}

	@Override
	public void localisateItemsNames() {
		AsynchronousWorkExecutionCoordinator.localisateItemsNames();
	}
}
