package agzam4.net.factory;

import agzam4.net.NetMenu;

/** Default {@link INetMenuFactory}, delegating to the unchanged {@link NetMenu} constructors. */
public class NetMenuFactory implements INetMenuFactory {

	@Override
	public NetMenu create() {
		return new NetMenu();
	}

	@Override
	public NetMenu create(String title) {
		return new NetMenu(title);
	}
}
