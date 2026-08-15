package agzam4.game.template.lexer;

/**
 * A single lexeme produced by {@link ITemplateLexer}: either a run of
 * literal text, or a placeholder name. For {@link TemplateLexerMode#FIELD}
 * placeholder tokens, {@link #text} is the raw {@code @name} slice
 * (leading {@code @} included) exactly as originally passed to
 * {@code Reflect.get(...)}/{@code Log.info(...)} by
 * {@code MindustryGameRuntimeFacade.formatByFileds} - this is a deliberately preserved quirk, not
 * an oversight. For {@link TemplateLexerMode#MAP} placeholder tokens,
 * {@link #text} excludes the leading {@code @}.
 */
public final class TemplateToken {

	public final TemplateTokenType type;
	public final String text;

	public TemplateToken(TemplateTokenType type, String text) {
		this.type = type;
		this.text = text;
	}
}
