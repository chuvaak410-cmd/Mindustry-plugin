package agzam4.game.template.lexer;

/**
 * Selects which of the two original {@code @}-scanning behaviours this
 * lexer run replicates. The two are NOT unifiable into one behaviour
 * without changing observable output, so the mode flag exists instead of
 * forcing a single code path:
 *
 * <ul>
 * <li>{@link #FIELD} - matches {@code MindustryGameRuntimeFacade.formatByFileds}: after emitting
 * a placeholder token the scan position only advances by one character
 * (not past the resolved name), so the field name's characters are
 * subsequently re-emitted as literal text too, and the placeholder name
 * slice includes the leading {@code @}. No {@code @@} escaping exists in
 * this mode.</li>
 * <li>{@link #MAP} - matches {@code MindustryGameRuntimeFacade.formatByMap} / {@code
 * MindustryGameRuntimeFacade.formatContent} (identical shape in the original): after emitting a
 * placeholder token the scan position advances past the resolved name, and
 * a placeholder immediately followed by a literal {@code @} consumes that
 * extra {@code @} as an escape/chain marker.</li>
 * </ul>
 */
public enum TemplateLexerMode {
	FIELD,
	MAP
}
