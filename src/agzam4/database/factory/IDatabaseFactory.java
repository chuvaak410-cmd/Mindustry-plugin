package agzam4.database.factory;

/**
 * Constructs (initializes) the plugin's database subsystem.
 */
public interface IDatabaseFactory {

	void createInitializedDatabase(String path) throws ClassNotFoundException;
}
