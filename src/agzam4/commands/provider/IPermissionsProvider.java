package agzam4.commands.provider;

import agzam4.commands.Permissions;

/** Delegating contract over the {@link Permissions} enum. */
public interface IPermissionsProvider {

	Permissions[] values();

	String nameOf(Permissions permission);
}
