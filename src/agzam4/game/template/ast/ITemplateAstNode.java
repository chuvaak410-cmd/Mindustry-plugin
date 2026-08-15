package agzam4.game.template.ast;

import agzam4.game.template.visitor.ITemplateResolutionVisitor;

/**
 * Base abstraction for a node in the template AST produced by
 * {@code ITemplateParser}. The only two concrete shapes are
 * {@link LiteralTemplateAstNode} (pass-through text) and
 * {@link PlaceholderTemplateAstNode} (an {@code @name} substitution site),
 * matching the two {@code TemplateTokenType}s.
 */
public interface ITemplateAstNode {

	String accept(ITemplateResolutionVisitor visitor);
}
