package agzam4.game.unit.registry;

import static mindustry.content.UnitTypes.*;

import mindustry.type.UnitType;

/**
 * Singleton default {@link IUnitTierRegistry}. Owns the same
 * {@code unitTiers} table moved here verbatim from {@code MindustryGameRuntimeFacade}.
 */
public final class UnitTierRegistry implements IUnitTierRegistry {

	private static final UnitTierRegistry INSTANCE = new UnitTierRegistry();

	private final UnitType[][] unitTiers = {
			{dagger,mace,fortress,scepter,reign},
			{nova,pulsar,quasar,vela,corvus},
			{crawler,atrax,spiroct,arkyid,toxopid},
			{flare,horizon,zenith,antumbra,eclipse},
			{mono,poly,mega,quad,oct},

			{risso,minke,bryde,sei,omura},
			{retusa,oxynoe,oxynoe,aegires,navanax},
			{alpha,beta,gamma},
			{stell,locus,precept,vanquish,conquer},
			{merui,cleroi,anthicus,tecta,collaris},

			{elude,avert,obviate,quell,disrupt},
			{renale,latum},
			{evoke,incite,emanate},
	};

	private UnitTierRegistry() {}

	public static UnitTierRegistry instance() {
		return INSTANCE;
	}

	@Override
	public UnitType[][] unitTiers() {
		return unitTiers;
	}
}
