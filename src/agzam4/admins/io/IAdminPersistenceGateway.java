package agzam4.admins.io;

import arc.files.Fi;

/**
 * The file persistence logic that used to live directly on
 * {@link agzam4.admins.Admins} as {@code load()}/{@code save()}, reading and
 * writing the flat {@code admins_data.txt} format unchanged.
 */
public interface IAdminPersistenceGateway {

	void load(Fi save);

	void save(Fi save);
}
