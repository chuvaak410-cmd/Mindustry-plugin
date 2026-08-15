package agzam4.provider;

import agzam4.stats.DataCollecter;

/** Default {@link IDataCollecterFactory}, delegating to the unchanged {@link DataCollecter}. */
public class DataCollecterFactory implements IDataCollecterFactory {

	@Override
	public DataCollecter create() {
		return new DataCollecter();
	}

	@Override
	public String pathToFile(String name) {
		return DataCollecter.getPathToFile(name);
	}
}
