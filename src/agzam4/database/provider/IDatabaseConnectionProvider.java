package agzam4.database.provider;

/**
 * Supplies access to the initialized {@link agzam4.database.Database}
 * facade. Introduced so consumers depend on a contract rather than the
 * static {@code Database} class directly, without altering any SQL
 * semantics owned by {@code Database}/{@code SQL}/{@code Table}.
 */
public interface IDatabaseConnectionProvider {

	void initializeConnection(String path) throws ClassNotFoundException;
}
