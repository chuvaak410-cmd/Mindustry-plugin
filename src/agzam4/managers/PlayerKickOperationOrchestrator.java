package agzam4.managers;

import agzam4.game.Images;
import agzam4.bot.Bots;
import agzam4.bot.TelegramBot;
import agzam4.commands.Server;
import agzam4.bot.Bots.NotifyTag;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.net.NetConnection;
import mindustry.net.Administration.Config;

public class PlayerKickOperationOrchestrator {

	public static void init() {
	}

	public static void kick(Player kicker, Player target, String reason) {
		kick(kicker.coloredName(), target, reason);
	}

	public static void kick(String kicker, Player target, String reason) {
		int minutes = 60;
		Bots.notify(NotifyTag.votekick, Strings.format("Выдан бан на <b>@</b> минут\nПричина: <i>@</i>\nБан выдал: <i>@</i>", minutes, TelegramBot.strip(reason), TelegramBot.strip(kicker)));
        Bots.notify(NotifyTag.votekick, Images.screenshot(target));
		
        kick(kicker, target, reason, minutes * 60);
		Call.sendMessage(Strings.format("[white]Игрок [orange]@[white] забанен на [orange]@[] минут [lightgray](причина: @)", target.plainName(), minutes, reason));
	}

	public static void sendDiscord(NetConnection con) {
		if(Server.discordLink != null && !Server.discordLink.isEmpty()) Call.openURI(con, Server.discordLink);
	}

	public static void kick(Player kicker, Player target, String reason, long seconds) {
		kick(kicker.coloredName(), target, reason, seconds);
	}

	public static void kick(String kicker, Player target, String reason, long seconds) {
		sendDiscord(target.con);
		target.kick(Strings.format("Вы были забанены на [red]@[] минут\nПричина: [orange]@[white]\nБан выдал: [orange]@[white]\nОбжаловать: @\n[white]Сервер: @", 
				seconds/60, reason, kicker, Server.discordLink, Config.serverName.get()), seconds * 1000);
		Vars.netServer.admins.handleKicked(target.uuid(), target.ip(), seconds * 1000);		
	}
	
}
