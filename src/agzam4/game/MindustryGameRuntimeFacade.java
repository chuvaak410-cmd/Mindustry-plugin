package agzam4.game;

import static mindustry.Vars.*;
import static mindustry.content.Blocks.*;

import agzam4.EnterpriseGradeMindustryServerPluginApplicationEntryPoint;
import agzam4.bot.Bots;
import agzam4.bot.Bots.NotifyTag;
import agzam4.game.combat.ExplosionDetonationStrategyImpl;
import agzam4.game.combat.IExplosionDetonationStrategy;
import agzam4.game.i18n.IMessageBundleGateway;
import agzam4.game.i18n.IMessageBundleLoaderService;
import agzam4.game.i18n.MessageBundleGatewayImpl;
import agzam4.game.i18n.MessageBundleLoaderServiceImpl;
import agzam4.game.ordnance.registry.ITurretRosterRegistry;
import agzam4.game.ordnance.registry.TurretRosterRegistry;
import agzam4.game.player.selector.IPlayerLookupSelector;
import agzam4.game.player.selector.PlayerLookupSelectorImpl;
import agzam4.game.template.ast.ITemplateAstNode;
import agzam4.game.template.lexer.TemplateLexerMode;
import agzam4.game.template.parser.ITemplateParser;
import agzam4.game.template.parser.TemplateParserImpl;
import agzam4.game.template.visitor.BundleTemplateResolutionVisitor;
import agzam4.game.template.visitor.ITemplateResolutionVisitor;
import agzam4.game.template.visitor.MapLookupTemplateResolutionVisitor;
import agzam4.game.template.visitor.ReflectiveFieldTemplateResolutionVisitor;
import agzam4.game.unit.strategy.IUnitClassificationStrategy;
import agzam4.game.unit.strategy.UnitClassificationStrategyImpl;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Position;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.Nullable;
import arc.util.Reflect;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.ctype.MappableContent;
import mindustry.entities.Effect;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.gen.Player;
import mindustry.gen.Posc;
import mindustry.net.Packets.KickReason;
import mindustry.type.Item;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;

/**
 * Thin coordinator - every original method signature is preserved, but the
 * actual logic now lives behind the {@code agzam4.game.*} subsystem seams
 * ({@code template}, {@code i18n}, {@code unit}, {@code ordnance},
 * {@code combat}, {@code player}). See {@code ENTERPRISE_TRANSFORMATION.md}
 * ("Pass 4") for the full breakdown.
 */
public class MindustryGameRuntimeFacade {

	private static final IMessageBundleLoaderService bundleLoader = MessageBundleLoaderServiceImpl.instance();
	private static final IMessageBundleGateway bundleGateway = new MessageBundleGatewayImpl();
	private static final ITemplateParser templateParser = new TemplateParserImpl();
	private static final IUnitClassificationStrategy unitClassificationStrategy = new UnitClassificationStrategyImpl();
	private static final IExplosionDetonationStrategy explosionDetonationStrategy = new ExplosionDetonationStrategyImpl();
	private static final IPlayerLookupSelector playerLookupSelector = new PlayerLookupSelectorImpl();
	private static final ITurretRosterRegistry turretRosterRegistry = TurretRosterRegistry.instance();

	public static void init() {
		bundleLoader.init();
	}

	public static final Block[] serpyloTurrets = turretRosterRegistry.serpyloTurrets();

	public static final Block[] erekirTurrets = turretRosterRegistry.erekirTurrets();

	public static final int bulletAfflictId = turretRosterRegistry.bulletAfflictId();
	public static final int bulletSmiteId = turretRosterRegistry.bulletSmiteId();

	public static Team defaultTeam() {
		return state.rules.defaultTeam;
	}

	public static void changeBuildingTeam(Building building, Team team) {
		building.tile.setNet(building.block, Team.crux, building.rotation);
	}

	public static void replaceBuilding(Building building, Block newBlock) {
		building.tile.setNet(newBlock, building.team, building.rotation);
	}

	public static void removeEnvBlock(int tileX, int tileY) {
		Tile tile = world.tile(tileX, tileY);
		if(tile == null) return;
		if(tile.build != null) return;
		tile.setNet(Blocks.air);
	}

	public static String colorToHex(Color color) {
    	return String.format("#%02x%02x%02x", (int)(color.r*255), (int)(color.g*255), (int)(color.b*255));
	}

	public static String getColoredLocalizedItemName(Item item) {
		return "[#" + item.color.toString() + "]" + contentName(item);
	}

	public static @Nullable Team getTeamByName(String name) {
		for (int i = 0; i < Team.baseTeams.length; i++) {
			if(Team.baseTeams[i].name.equalsIgnoreCase(name)) return Team.baseTeams[i];
		}
		return null;
	}

	public static boolean supportsEnv(Block block) {
		return block.supportsEnv(Vars.state.rules.env);
	}

	public static boolean supportsEnv(UnitType type) {
		return type.supportsEnv(Vars.state.rules.env);
	}

	public static Block getBlockByEmoji(String emoji) {
		for (int i = 0; i < Vars.content.blocks().size; i++) {
			Block block = Vars.content.blocks().get(i);
			if(block.hasEmoji()) {
				if(emoji.equals(block.emoji())) return block;
			}
		}
		return null;
	}

	public static int roundMax(float value) {
		if(value > 0) return Mathf.ceil(value);
		return Mathf.floor(value);
	}

	public static int classGround 		= 1;
	public static int classGroundGreen 	= 2;
	public static int classSpider 		= 3;
	public static int classAir 			= 4;
	public static int classAirGreen 	= 5;
	public static int classNaval 		= 6;
	public static int classNavalGreen 	= 7;
	public static int classCore 		= 8;
	public static int classTank 		= 9;
	public static int classCrab 		= 10;
	public static int classAirErekir 	= 11;
	public static int clasHug			= 12;
	public static int classCoreErekir 	= 13;

	/**
	 * Get unit tier (1 - start tier, 0 - not found)
	 * @param unit - type of unit
	 * @return
	 */
	public static int getUnitTier(UnitType unit) {
		return unitClassificationStrategy.getUnitTier(unit);
	}


	public static int getUnitClass(UnitType unit) {
		return unitClassificationStrategy.getUnitClass(unit);
	}

	/**
	 * Creating explosion at (x,y) for any type of units (ground and air)
	 * @param team - owner of explosion (wasn't damaged)
	 * @param x - x position of explosion in world units
	 * @param y - x position of explosion in world units
	 * @param radius - radius of explosion in world units
	 * @param damage - amount of damage
	 */
	public static void explosion(Team team, Posc pos, float radius, float damage) {
		explosion(team, pos.x(), pos.y(), radius, damage, true, true, false);
	}

	/**
	 * Creating explosion at (x,y) for any type of units (ground and air)
	 * @param team - owner of explosion (wasn't damaged)
	 * @param x - x position of explosion in world units
	 * @param y - x position of explosion in world units
	 * @param radius - radius of explosion in world units
	 * @param damage - amount of damage
	 */
	public static void explosion(Team team, float x, float y, float radius, float damage) {
		explosion(team, x, y, radius, damage, true, true, false);
	}

	/**
	 * Creating explosion at (x,y) for any type of units (ground and air)
	 * @param team - owner of explosion (wasn't damaged)
	 * @param x - x position of explosion in world units
	 * @param y - x position of explosion in world units
	 * @param radius - radius of explosion in world units
	 * @param damage - amount of damage
	 * @param pierce - is damage piercing
	 */
	public static void explosion(Team team, float x, float y, float radius, float damage, boolean pierce) {
		explosion(team, x, y, radius, damage, true, true, pierce);
	}

	/**
	 * Creating explosion at (x,y)
	 * @param team - owner of explosion (wasn't damaged)
	 * @param x - x position of explosion in world units
	 * @param y - x position of explosion in world units
	 * @param radius - radius of explosion in world units
	 * @param damage - amount of damage
	 * @param ground - is ground units was damaged
	 * @param air - is air units was damaged
	 * @param pierce - is damage piercing
	 */
	public static void explosion(Team team, float x, float y, float radius, float damage, boolean ground, boolean air, boolean pierce) {
		explosionDetonationStrategy.explosion(team, x, y, radius, damage, ground, air, pierce);
	}

	public static Block getWateredFloor(Floor floor) {
		if(floor == sand || floor == sandWater) return sandWater;
		if(floor == darksand || floor == darksandWater) return darksandWater;
		if(floor == moss || floor == sporeMoss || floor == taintedWater) return taintedWater;
		return water;
	}

	public static void effectPositioned(Effect effect, float x, float y, float size, Color color, Position position) {
		Call.effect(effect, x, y, size, color, position);
	}

	public static void effect(Effect effect, Position position, float size, Color color) {
		Call.effect(effect, position.getX(), position.getY(), size, color);
	}

	public static void effect(Effect effect, float x, float y, float size, Color color) {
		Call.effect(effect, x, y, size, color);
	}

	public static @Nullable Player findPlayer(final String s) {
		return playerLookupSelector.find(s);
	}

	@Deprecated
	public static Seq<String> playersNames() {
		Seq<String> names = new Seq<String>(Groups.player.size());
		Groups.player.each(p -> names.add(p.name));
		return names;
	}

	public static @Nullable Block findBlock(String name) {
		Block b = Vars.content.block(name);
		if(b != null) return b;
		b = Vars.content.blocks().find(s -> s.hasEmoji() && s.emoji().equals(name));
		if(b != null) return b;
		try {
			return Reflect.get(Blocks.class, null, name);
		} catch (Exception | Error e) {
			return null;
		}
	}

	public static String strip(String s) {
		return Strings.stripColors(Strings.stripGlyphs(s));
	}

	public static float getAttribute(int x, int y, Attribute att) {
		Tile t = Vars.world.tile(x, y);
		if(t == null) return 0;
		return t.floor().attributes.get(att);
	}

	public static String round(float f) {
		return Strings.autoFixed(f, 2);
	}

	public static String bungle(String string) {
		return bundleGateway.bungle(string);
	}

	public static String bungleDef(String string, String def) {
		return bundleGateway.bungleDef(string, def);
	}

	public static String bungle(String text, Object... args) {
		return bundleGateway.bungle(text, args);
	}

	public static String formatByFileds(String src, Object object) {
		Seq<ITemplateAstNode> nodes = templateParser.parse(src, TemplateLexerMode.FIELD);
		ITemplateResolutionVisitor visitor = new ReflectiveFieldTemplateResolutionVisitor(object);
		StringBuilder result = new StringBuilder();
		for (ITemplateAstNode node : nodes) {
			result.append(node.accept(visitor));
		}
		return result.toString();
	}

	public static Object formatByMap(String src, ObjectMap<String, Object> props) {
		Seq<ITemplateAstNode> nodes = templateParser.parse(src, TemplateLexerMode.MAP);
		ITemplateResolutionVisitor visitor = new MapLookupTemplateResolutionVisitor(props);
		StringBuilder result = new StringBuilder();
		for (ITemplateAstNode node : nodes) {
			result.append(node.accept(visitor));
		}
		return result.toString();
	}

	public static String formatContent(String src) {
		Seq<ITemplateAstNode> nodes = templateParser.parse(src, TemplateLexerMode.MAP);
		ITemplateResolutionVisitor visitor = new BundleTemplateResolutionVisitor();
		StringBuilder result = new StringBuilder();
		for (ITemplateAstNode node : nodes) {
			result.append(node.accept(visitor));
		}
		return result.toString();
	}

	public static String contentName(MappableContent content) {
		return bundleGateway.contentName(content);
	}

	public static void sync() {
		Call.worldDataBegin();
		Groups.player.each(p -> Vars.netServer.sendWorldData(p));
	}

	public static void clearUnit(Player player) {
		UnitType type = mindustry.content.UnitTypes.alpha;
		Position pos = player;
		var core = player.bestCore();
		if(core != null) {
			pos = core;
			if(core.block instanceof CoreBlock block) {
				type = block.unitType;
			}
		}
		var u = type.spawn(player.team(), pos);
		u.spawnedByCore = true;
		u.add();
		player.unit(u);
	}

	public static void stop() {
		Bots.notify(NotifyTag.serverInfo, null, "Stoping server...");
		Groups.player.each(p -> {
			p.kick(KickReason.serverRestarting);
		});
		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.serverHandler.handleMessage("stop");
		EnterpriseGradeMindustryServerPluginApplicationEntryPoint.serverHandler.handleMessage("exit");
		System.exit(0);
	}
}
