package agzam4.game.template.visitor;

import agzam4.game.i18n.IMessageBundleLoaderService;
import agzam4.game.i18n.MessageBundleLoaderServiceImpl;
import agzam4.game.template.ast.LiteralTemplateAstNode;
import agzam4.game.template.ast.PlaceholderTemplateAstNode;

/**
 * Resolution visitor standing in for {@code MindustryGameRuntimeFacade.formatContent}: looks the
 * placeholder name up as {@code "global." + name} in the shared message
 * bundle owned by {@link MessageBundleLoaderServiceImpl}, falling back to
 * the same {@code "[red]???name???[]"} marker on a miss.
 */
public class BundleTemplateResolutionVisitor implements ITemplateResolutionVisitor {

	private final IMessageBundleLoaderService loader = MessageBundleLoaderServiceImpl.instance();

	@Override
	public String visitLiteral(LiteralTemplateAstNode node) {
		return node.text();
	}

	@Override
	public String visitPlaceholder(PlaceholderTemplateAstNode node) {
		Object value = loader.bundle().get("global." + node.name());
		if (value == null) return "[red]???" + node.name() + "???[]";
		return value.toString();
	}
}
