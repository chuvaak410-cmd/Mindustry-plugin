package agzam4.game.template.parser;

import agzam4.game.template.ast.ITemplateAstNode;
import agzam4.game.template.lexer.TemplateLexerMode;
import arc.struct.Seq;

/** Turns a raw template {@code String} into an ordered {@link ITemplateAstNode} sequence. */
public interface ITemplateParser {

	Seq<ITemplateAstNode> parse(String src, TemplateLexerMode mode);
}
