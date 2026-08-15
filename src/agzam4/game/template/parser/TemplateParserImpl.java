package agzam4.game.template.parser;

import agzam4.game.template.ast.ITemplateAstNode;
import agzam4.game.template.ast.LiteralTemplateAstNode;
import agzam4.game.template.ast.PlaceholderTemplateAstNode;
import agzam4.game.template.lexer.ITemplateLexer;
import agzam4.game.template.lexer.TemplateLexerImpl;
import agzam4.game.template.lexer.TemplateLexerMode;
import agzam4.game.template.lexer.TemplateToken;
import arc.struct.Seq;

/**
 * Default {@link ITemplateParser}. Recursive-descent over the token
 * stream: since {@link ITemplateLexer} already resolved every boundary and
 * escaping decision, each token maps to exactly one AST node with no
 * lookahead required beyond the token itself.
 */
public class TemplateParserImpl implements ITemplateParser {

	private final ITemplateLexer lexer = new TemplateLexerImpl();

	@Override
	public Seq<ITemplateAstNode> parse(String src, TemplateLexerMode mode) {
		Seq<TemplateToken> tokens = lexer.lex(src, mode);
		Seq<ITemplateAstNode> nodes = new Seq<>(tokens.size);
		parseNodes(tokens, 0, nodes);
		return nodes;
	}

	private void parseNodes(Seq<TemplateToken> tokens, int index, Seq<ITemplateAstNode> nodes) {
		if (index >= tokens.size) return;
		TemplateToken token = tokens.get(index);
		switch (token.type) {
			case LITERAL -> nodes.add(new LiteralTemplateAstNode(token.text));
			case PLACEHOLDER -> nodes.add(new PlaceholderTemplateAstNode(token.text));
		}
		parseNodes(tokens, index + 1, nodes);
	}
}
