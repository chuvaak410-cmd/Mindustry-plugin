package agzam4.game.unit.registry;

import mindustry.type.UnitType;

/**
 * Discoverable seam over the {@code unitTiers} 2D array that used to be a
 * public static field directly on {@code MindustryGameRuntimeFacade}.
 */
public interface IUnitTierRegistry {

	UnitType[][] unitTiers();
}
