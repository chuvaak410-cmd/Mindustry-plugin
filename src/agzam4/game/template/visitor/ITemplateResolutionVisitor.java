package agzam4.game.template.visitor;

import agzam4.game.template.ast.LiteralTemplateAstNode;
import agzam4.game.template.ast.PlaceholderTemplateAstNode;

/**
 * Resolves AST nodes to their final {@code String} contribution. Literal
 * nodes always pass through unchanged; placeholder nodes are resolved
 * according to whichever original {@code MindustryGameRuntimeFacade.format*} method this visitor
 * stands in for.
 */
public interface ITemplateResolutionVisitor {

	String visitLiteral(LiteralTemplateAstNode node);

	String visitPlaceholder(PlaceholderTemplateAstNode node);
}
