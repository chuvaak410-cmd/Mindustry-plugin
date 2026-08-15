package agzam4.database.factory;

import agzam4.database.Database;

/**
 * Default {@link IDatabaseFactory}. Thin wrapper over
 * {@link Database#init(String)} - the connection string handling, SQLite
 * driver loading and table wiring all remain exactly as implemented in
 * {@code Database}.
 */
public class DatabaseFactory implements IDatabaseFactory {

	@Override
	public void createInitializedDatabase(String path) throws ClassNotFoundException {
		Database.init(path);
	}
}
