package agzam4.game.template.lexer;

/**
 * Discriminates the two kinds of {@link TemplateToken} produced by
 * {@link ITemplateLexer}: literal text passed through untouched, and
 * {@code @name} placeholders awaiting resolution by a visitor.
 */
public enum TemplateTokenType {
	LITERAL,
	PLACEHOLDER
}
