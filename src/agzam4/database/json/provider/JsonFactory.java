package agzam4.database.json.provider;

import agzam4.database.json.Json;

/** Default {@link IJsonFactory}, delegating to the unchanged {@link Json} constructor. */
public class JsonFactory implements IJsonFactory {

	@Override
	public Json create() {
		return new Json();
	}
}
