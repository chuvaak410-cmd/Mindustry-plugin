package agzam4.provider;

import mindustry.type.UnitType;

/** Delegating contract over the static {@link agzam4.utils.AsynchronousWorkExecutionCoordinator} helpers. */
public interface IWorkProvider {

	boolean isPlayerUnit(UnitType unit);

	void localisateItemsNames();
}
