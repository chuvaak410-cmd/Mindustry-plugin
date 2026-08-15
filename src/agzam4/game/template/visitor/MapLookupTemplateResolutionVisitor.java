package agzam4.game.template.visitor;

import agzam4.game.template.ast.LiteralTemplateAstNode;
import agzam4.game.template.ast.PlaceholderTemplateAstNode;
import arc.struct.ObjectMap;

/** Resolution visitor standing in for {@code MindustryGameRuntimeFacade.formatByMap}: looks the placeholder name up in a props map. */
public class MapLookupTemplateResolutionVisitor implements ITemplateResolutionVisitor {

	private final ObjectMap<String, Object> props;

	public MapLookupTemplateResolutionVisitor(ObjectMap<String, Object> props) {
		this.props = props;
	}

	@Override
	public String visitLiteral(LiteralTemplateAstNode node) {
		return node.text();
	}

	@Override
	public String visitPlaceholder(PlaceholderTemplateAstNode node) {
		Object value = props.get(node.name());
		if (value == null) return "null";
		return value.toString();
	}
}
