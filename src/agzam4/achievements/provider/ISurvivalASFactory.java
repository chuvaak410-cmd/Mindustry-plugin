package agzam4.achievements.provider;

import agzam4.achievements.SurvivalAS;

/** Factory contract for constructing {@link SurvivalAS} instances through the provider layer. */
public interface ISurvivalASFactory {

	SurvivalAS create();
}
