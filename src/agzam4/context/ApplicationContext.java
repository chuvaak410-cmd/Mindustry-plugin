package agzam4.context;

import mindustry.Vars;
import mindustry.mod.Mods.LoadedMod;

public class ApplicationContext implements IApplicationContext {

	private final LoadedMod loadedMod;

	public ApplicationContext(LoadedMod loadedMod) {
		this.loadedMod = loadedMod;
	}

	@Override
	public LoadedMod loadedMod() {
		return loadedMod;
	}

	public static ApplicationContext fromCurrentMods() {
		return new ApplicationContext(Vars.mods.getMod("agzam4plugin"));
	}
}
