package agzam4.net.provider;

import agzam4.net.NetMenu;

/** Default {@link INetMenuProvider}, delegating to the unchanged {@link NetMenu#init()}. */
public class NetMenuProvider implements INetMenuProvider {

	@Override
	public void initialize() {
		NetMenu.init();
	}
}
