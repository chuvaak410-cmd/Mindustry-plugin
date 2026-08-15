package agzam4.database.json.provider;

import agzam4.database.json.Json;

/** Factory contract producing the (deprecated, effectively unused) {@link Json} helper. */
public interface IJsonFactory {

	Json create();
}
