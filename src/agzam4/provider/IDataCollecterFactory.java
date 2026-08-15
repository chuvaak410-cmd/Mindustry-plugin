package agzam4.provider;

import agzam4.stats.DataCollecter;

/** Factory contract for constructing the singleton {@link DataCollecter}. */
public interface IDataCollecterFactory {

	DataCollecter create();

	String pathToFile(String name);
}
