package agzam4.game.template.ast;

import agzam4.game.template.visitor.ITemplateResolutionVisitor;

/**
 * An {@code @name} substitution site. Per {@code TemplateLexerMode}, in
 * field-reflection templates {@link #name} still carries its leading
 * {@code @} (preserved original quirk); in map/bundle templates it does
 * not.
 */
public final class PlaceholderTemplateAstNode implements ITemplateAstNode {

	private final String name;

	public PlaceholderTemplateAstNode(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	@Override
	public String accept(ITemplateResolutionVisitor visitor) {
		return visitor.visitPlaceholder(this);
	}
}
