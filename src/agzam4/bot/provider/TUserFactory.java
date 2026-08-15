package agzam4.bot.provider;

import agzam4.bot.TUser;
import arc.util.Nullable;

/** Default {@link ITUserFactory}, delegating to the unchanged {@link TUser} constructors/statics. */
public class TUserFactory implements ITUserFactory {

	@Override
	public TUser create(long id) {
		return new TUser(id);
	}

	@Override
	public @Nullable TUser read(String data) {
		return TUser.read(data);
	}
}
