package agzam4.utils.provider;

/** Delegating contract over the static {@link agzam4.utils.ApplicationDiagnosticMessageGateway} facade. */
public interface ILogProvider {

	void initialize();

	void reset();

	void info(Object... args);

	void warn(Object... args);

	void err(Throwable e);
}
