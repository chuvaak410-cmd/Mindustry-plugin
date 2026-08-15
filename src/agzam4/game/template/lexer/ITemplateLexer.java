package agzam4.game.template.lexer;

import arc.struct.Seq;

/**
 * Tokenizes a template {@code String} into literal/placeholder
 * {@link TemplateToken}s. See {@link TemplateLexerMode} for the two
 * distinct boundary/escaping rulesets this can replicate - both are
 * carried over verbatim (including the shared, un-fixed
 * {@code StringIndexOutOfBoundsException} risk when a trailing {@code @} is
 * followed only by alphabetic characters to the end of the string) from
 * the original {@code MindustryGameRuntimeFacade.formatByFileds}/{@code formatByMap}/
 * {@code formatContent} char-scanning loops.
 */
public interface ITemplateLexer {

	Seq<TemplateToken> lex(String src, TemplateLexerMode mode);
}
