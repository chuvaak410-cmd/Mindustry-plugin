package agzam4.game.template.lexer;

import arc.struct.Seq;

/**
 * Default {@link ITemplateLexer}. Reproduces, character index for
 * character index, the two original scanning loops from
 * {@code agzam4.game.MindustryGameRuntimeFacade} (before this pass's extraction):
 *
 * <pre>
 * for (j = i + 1; Character.isAlphabetic(src.charAt(j)) && j &lt; src.length(); j++);
 * </pre>
 *
 * evaluated in that exact order (alphabetic check before the length guard,
 * so a placeholder running to the very end of the string throws
 * {@code StringIndexOutOfBoundsException} exactly as the original did -
 * this is intentionally not defended against), plus the divergent
 * post-scan cursor handling described on {@link TemplateLexerMode}.
 */
public class TemplateLexerImpl implements ITemplateLexer {

	@Override
	public Seq<TemplateToken> lex(String src, TemplateLexerMode mode) {
		Seq<TemplateToken> tokens = new Seq<>();
		StringBuilder literal = new StringBuilder();
		int i = 0;
		while (i < src.length()) {
			char c = src.charAt(i);
			if (c == '@') {
				int j = i + 1;
				while (Character.isAlphabetic(src.charAt(j)) && j < src.length()) {
					j++;
				}
				if (literal.length() > 0) {
					tokens.add(new TemplateToken(TemplateTokenType.LITERAL, literal.toString()));
					literal.setLength(0);
				}
				if (mode == TemplateLexerMode.FIELD) {
					tokens.add(new TemplateToken(TemplateTokenType.PLACEHOLDER, src.substring(i, j)));
					i = i + 1;
				} else {
					tokens.add(new TemplateToken(TemplateTokenType.PLACEHOLDER, src.substring(i + 1, j)));
					i = j;
					if (src.charAt(j) == '@') i++;
				}
				continue;
			}
			literal.append(c);
			i++;
		}
		if (literal.length() > 0) {
			tokens.add(new TemplateToken(TemplateTokenType.LITERAL, literal.toString()));
		}
		return tokens;
	}
}
