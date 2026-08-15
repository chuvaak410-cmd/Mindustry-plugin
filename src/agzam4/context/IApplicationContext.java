package agzam4.context;

import mindustry.mod.Mods.LoadedMod;

/**
 * Holds the small amount of ambient state the plugin needs before/around the
 * dependency injection container exists - namely the reference to this
 * plugin's own {@link LoadedMod} entry.
 */
public interface IApplicationContext {

	LoadedMod loadedMod();
}
