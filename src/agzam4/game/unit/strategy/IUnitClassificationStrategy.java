package agzam4.game.unit.strategy;

import mindustry.type.UnitType;

/**
 * The tier/class lookup logic that used to live directly on {@code MindustryGameRuntimeFacade}
 * ({@code getUnitTier}, {@code getUnitClass}), reading from
 * {@link agzam4.game.unit.registry.IUnitTierRegistry}.
 */
public interface IUnitClassificationStrategy {

	/**
	 * Get unit tier (1 - start tier, 0 - not found)
	 * @param unit - type of unit
	 * @return
	 */
	int getUnitTier(UnitType unit);

	int getUnitClass(UnitType unit);
}
