package agzam4.lifecycle;

import agzam4.EnterpriseGradeMindustryServerPluginApplicationEntryPoint;
import agzam4.game.MindustryGameRuntimeFacade;
import agzam4.game.Images;
import agzam4.bot.Bots;
import agzam4.bot.Bots.NotifyTag;
import agzam4.bot.TelegramBot;
import agzam4.events.ServerEventsManager;
import agzam4.events.pipeline.EventPipeline;
import agzam4.votes.SkipmapVoteSession;
import arc.Events;
import arc.util.Strings;
import arc.util.Timer;
import mindustry.content.Blocks;
import mindustry.entities.units.BuildPlan;
import mindustry.game.EventType.BlockBuildBeginEvent;
import mindustry.game.EventType.GameOverEvent;
import mindustry.game.EventType.ServerLoadEvent;
import mindustry.game.EventType.Trigger;
import mindustry.game.EventType.WorldLoadBeginEvent;
import mindustry.game.EventType.WorldLoadEndEvent;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.gen.Unit;

import static agzam4.utils.UnicodeEmoticonResolutionProvider.emojiAlert;
import static mindustry.Vars.state;
import static mindustry.Vars.world;

/**
 * Registers the plugin's recurring/event-driven behaviour: the per-frame
 * update tick (now routed through {@link EventPipeline}) and every
 * {@code Events.on(...)} listener that used to be registered directly inside
 * {@code EnterpriseGradeMindustryServerPluginApplicationEntryPoint.init()}. Listener bodies are unchanged.
 */
public class RuntimeLifecyclePhase implements ILifecyclePhase {

	private final EventPipeline eventPipeline = new EventPipeline();

	@Override
	public void run() {
		Events.run(Trigger.update, () -> {
			eventPipeline.runUpdateTick();
			EnterpriseGradeMindustryServerPluginApplicationEntryPoint.dataCollect.update();
		});

		Events.on(ServerLoadEvent.class, e -> {
			Images.init();
		});

		Events.on(GameOverEvent.class, e -> {
			StringBuilder result = new StringBuilder(state.map.name());
			result.append("\nСчёт: [lightgray]");
			result.append(state.wave);
			result.append('/');
			result.append(state.map.getHightScore());
			if(state.wave > state.map.getHightScore()) {
				result.append("[gold] (Новый рекорд!)");
				state.map.setHighScore(state.wave);
			}
			Call.sendMessage(result.toString());
			SkipmapVoteSession.stop();
			Bots.notify(NotifyTag.round, "<b>Game over</b>: " + state.wave + "/" + state.map.getHightScore());
		});

		Events.on(WorldLoadBeginEvent.class, e -> {
			mindustry.Vars.state.rules.deconstructRefundMultiplier = .51f;
		});

		Events.on(WorldLoadEndEvent.class, e -> {
			SkipmapVoteSession.stop();
			ServerEventsManager.worldLoadEnd(e);
			Timer.schedule(() -> {
				Bots.notify(NotifyTag.round, Strings.format("<b>Next map is:</b> <code>@</code>", TelegramBot.strip(state.map.plainName())));
			}, 1f);
		});

		/**
		 * Info message about builder, that building thoriumReactor
		 */
		Events.on(BlockBuildBeginEvent.class, event -> {
			Unit builder = event.unit;
			if(builder == null) return;
			BuildPlan buildPlan = builder.buildPlan();
			if(buildPlan == null) return;
			if(!event.breaking && builder.buildPlan().block == Blocks.thoriumReactor && builder.isPlayer()) {
				Player player = builder.getPlayer();

				int bx = (event.tile.x * 3 / world.width()) - 1;
				int by = (event.tile.y * 3 / world.height()) - 1;

				String position = "";
				if(by == 0) {
					position = "по центру";
					if(bx == -1) position += " слева";
					if(bx == 1) position += " справа";
				}
				if(bx == 0) {
					if(by == 1) position = "вверху";
					if(by == -1) position = "внизу";
					position += " в центре";
				}
				if(bx != 0 && by != 0) {
					if(bx == -1) position = "левый";
					if(bx == 1) position = "правый";
					if(by == 1) position += " верхний";
					if(by == -1) position += " нижний";
					position += " угол карты";
				}
				if(bx == 0 && by == 0) position = "центр карты";

				Call.sendMessage("[gold]" + emojiAlert + " Внимание " + emojiAlert + " []Игрок [" + MindustryGameRuntimeFacade.colorToHex(player.color()) + "]" + player.name + " []строит реактор (" + position + ")");
			}
		});
	}

	@Override
	public String phaseName() {
		return "runtime";
	}
}
