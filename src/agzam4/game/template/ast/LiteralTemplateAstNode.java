package agzam4.game.template.ast;

import agzam4.game.template.visitor.ITemplateResolutionVisitor;

/** A run of literal template text, emitted unchanged by every resolution visitor. */
public final class LiteralTemplateAstNode implements ITemplateAstNode {

	private final String text;

	public LiteralTemplateAstNode(String text) {
		this.text = text;
	}

	public String text() {
		return text;
	}

	@Override
	public String accept(ITemplateResolutionVisitor visitor) {
		return visitor.visitLiteral(this);
	}
}
