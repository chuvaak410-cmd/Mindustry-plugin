package agzam4.net.factory;

import agzam4.net.NetMenu;

/**
 * Factory seam for {@link NetMenu} instances. This is the one place allowed
 * to call {@code new NetMenu(...)} directly, per this codebase's convention
 * of routing object creation through factories.
 */
public interface INetMenuFactory {

	NetMenu create();

	NetMenu create(String title);
}
