package agzam4.achievements.provider;

import agzam4.achievements.SurvivalAS;

/** Default {@link ISurvivalASFactory}, delegating to the unchanged {@code new SurvivalAS()}. */
public class SurvivalASFactory implements ISurvivalASFactory {

	@Override
	public SurvivalAS create() {
		return new SurvivalAS();
	}
}
