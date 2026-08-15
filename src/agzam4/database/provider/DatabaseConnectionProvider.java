package agzam4.database.provider;

import agzam4.database.Database;
import agzam4.database.factory.DatabaseFactory;

/**
 * Default {@link IDatabaseConnectionProvider}. Delegates to the
 * {@link DatabaseFactory}, which in turn delegates to the original
 * {@link Database#init(String)} - identical SQL/JDBC behaviour, just
 * reached through the provider/factory layer instead of a direct static
 * call.
 */
public class DatabaseConnectionProvider implements IDatabaseConnectionProvider {

	private final DatabaseFactory databaseFactory = new DatabaseFactory();

	@Override
	public void initializeConnection(String path) throws ClassNotFoundException {
		databaseFactory.createInitializedDatabase(path);
	}
}
