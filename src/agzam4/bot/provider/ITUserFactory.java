package agzam4.bot.provider;

import agzam4.bot.TUser;
import arc.util.Nullable;

/** Factory contract mirroring {@link TUser#read(String)} and the id constructor. */
public interface ITUserFactory {

	TUser create(long id);

	@Nullable TUser read(String data);
}
