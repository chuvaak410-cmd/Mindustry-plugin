package agzam4.commands.provider;

import agzam4.commands.Permissions;

/** Default {@link IPermissionsProvider}, delegating to the unchanged {@link Permissions} enum. */
public class PermissionsProvider implements IPermissionsProvider {

	@Override
	public Permissions[] values() {
		return Permissions.values();
	}

	@Override
	public String nameOf(Permissions permission) {
		return permission.name;
	}
}
