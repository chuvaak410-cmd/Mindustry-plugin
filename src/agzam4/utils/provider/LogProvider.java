package agzam4.utils.provider;

import agzam4.utils.ApplicationDiagnosticMessageGateway;

/** Default {@link ILogProvider}, delegating to the unchanged {@link ApplicationDiagnosticMessageGateway} statics. */
public class LogProvider implements ILogProvider {

	@Override
	public void initialize() {
		ApplicationDiagnosticMessageGateway.init();
	}

	@Override
	public void reset() {
		ApplicationDiagnosticMessageGateway.reset();
	}

	@Override
	public void info(Object... args) {
		ApplicationDiagnosticMessageGateway.info(args);
	}

	@Override
	public void warn(Object... args) {
		ApplicationDiagnosticMessageGateway.warn(args);
	}

	@Override
	public void err(Throwable e) {
		ApplicationDiagnosticMessageGateway.err(e);
	}
}
