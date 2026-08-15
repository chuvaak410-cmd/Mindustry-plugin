package agzam4.net.selector;

import agzam4.net.NetMenu;
import agzam4.net.registry.NetMenuRegistry;
import mindustry.game.EventType.MenuOptionChooseEvent;

/**
 * Routes a {@link MenuOptionChooseEvent} to the {@link NetMenu} it belongs
 * to. This is the exact logic that used to live inline inside
 * {@code NetMenu.init()}'s {@code Events.on(MenuOptionChooseEvent.class, ...)}
 * lambda: resolve the menu via the registry, validate ownership, dispatch to
 * a close listener or the chosen option's listener, and re-show the menu if
 * it is builder-driven - unchanged, just relocated behind a selector seam.
 */
public class NetMenuOptionDispatchSelector {

	private final NetMenuRegistry registry = NetMenuRegistry.instance();

	public void dispatch(MenuOptionChooseEvent e) {
		var menu = registry.remove(e.menuId);
		if(menu == null) {
			return;
		}
		if(menu.player() != e.player) return;
		if(e.option < 0) {
			if(menu.onCloseListener() != null) menu.onCloseListener().get();
			return;
		}
		menu.listenerAt(e.option).get();
		if(menu.hasBuilder()) menu.show(menu.player());
	}
}
