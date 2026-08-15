package agzam4.bootstrap;

/**
 * Top level entry point invoked by {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()}. Everything
 * that used to happen inline inside {@code init()} now happens behind this
 * single {@link #launch()} call.
 */
public interface IApplicationLauncher {

	void launch();
}
