package agzam4.game.unit.strategy;

import agzam4.game.unit.registry.IUnitTierRegistry;
import agzam4.game.unit.registry.UnitTierRegistry;
import mindustry.type.UnitType;

/** Default {@link IUnitClassificationStrategy}, mirroring the original {@code MindustryGameRuntimeFacade} logic exactly. */
public class UnitClassificationStrategyImpl implements IUnitClassificationStrategy {

	private final IUnitTierRegistry registry = UnitTierRegistry.instance();

	@Override
	public int getUnitTier(UnitType unit) {
		UnitType[][] unitTiers = registry.unitTiers();
		for (int type = 0; type < unitTiers.length; type++) {
			for (int tier = 0; tier < unitTiers[type].length; tier++) {
				if(unitTiers[type][tier] == unit) return tier+1;
			}
		}
		return 0;
	}

	@Override
	public int getUnitClass(UnitType unit) {
		UnitType[][] unitTiers = registry.unitTiers();
		for (int type = 0; type < unitTiers.length; type++) {
			for (int tier = 0; tier < unitTiers[type].length; tier++) {
				if(unitTiers[type][tier] == unit) return type+1;
			}
		}
		return 0;
	}
}
