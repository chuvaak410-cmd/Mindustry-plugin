package agzam4.provider;

import agzam4.utils.DiagnosticInformationEmissionUtility;

/** Default {@link IDebugProvider}, delegating to the unchanged {@link DiagnosticInformationEmissionUtility} statics. */
public class DebugProvider implements IDebugProvider {

	@Override
	public boolean configDebug() {
		return DiagnosticInformationEmissionUtility.configDebug();
	}
}
