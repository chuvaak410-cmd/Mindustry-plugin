package agzam4.managers.provider;

import mindustry.gen.Player;
import mindustry.net.NetConnection;

/** Delegating contract over the static {@link agzam4.managers.PlayerKickOperationOrchestrator} facade. */
public interface IKicksProvider {

	void initialize();

	void kick(Player kicker, Player target, String reason);

	void kick(String kicker, Player target, String reason);

	void kick(Player kicker, Player target, String reason, long seconds);

	void kick(String kicker, Player target, String reason, long seconds);

	void sendDiscord(NetConnection con);
}
