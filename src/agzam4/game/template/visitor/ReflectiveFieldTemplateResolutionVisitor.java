package agzam4.game.template.visitor;

import agzam4.game.template.ast.LiteralTemplateAstNode;
import agzam4.game.template.ast.PlaceholderTemplateAstNode;
import arc.util.Log;
import arc.util.Reflect;

/**
 * Resolution visitor standing in for {@code MindustryGameRuntimeFacade.formatByFileds}. Resolves
 * a placeholder via {@code Reflect.get(object, name)} - note {@code name}
 * still carries its leading {@code @} here, exactly as the original
 * {@code src.substring(i, j)} did - and logs {@code Log.info("field: @",
 * name)} per placeholder, unchanged.
 */
public class ReflectiveFieldTemplateResolutionVisitor implements ITemplateResolutionVisitor {

	private final Object object;

	public ReflectiveFieldTemplateResolutionVisitor(Object object) {
		this.object = object;
	}

	@Override
	public String visitLiteral(LiteralTemplateAstNode node) {
		return node.text();
	}

	@Override
	public String visitPlaceholder(PlaceholderTemplateAstNode node) {
		Object value = Reflect.get(object, node.name());
		Log.info("field: @", node.name());
		if (value == null) return "null";
		return value.toString();
	}
}
