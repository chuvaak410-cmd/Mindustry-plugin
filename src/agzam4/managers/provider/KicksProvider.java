package agzam4.managers.provider;

import agzam4.managers.PlayerKickOperationOrchestrator;
import mindustry.gen.Player;
import mindustry.net.NetConnection;

/** Default {@link IKicksProvider}, delegating to the unchanged {@link PlayerKickOperationOrchestrator} statics. */
public class KicksProvider implements IKicksProvider {

	@Override
	public void initialize() {
		PlayerKickOperationOrchestrator.init();
	}

	@Override
	public void kick(Player kicker, Player target, String reason) {
		PlayerKickOperationOrchestrator.kick(kicker, target, reason);
	}

	@Override
	public void kick(String kicker, Player target, String reason) {
		PlayerKickOperationOrchestrator.kick(kicker, target, reason);
	}

	@Override
	public void kick(Player kicker, Player target, String reason, long seconds) {
		PlayerKickOperationOrchestrator.kick(kicker, target, reason, seconds);
	}

	@Override
	public void kick(String kicker, Player target, String reason, long seconds) {
		PlayerKickOperationOrchestrator.kick(kicker, target, reason, seconds);
	}

	@Override
	public void sendDiscord(NetConnection con) {
		PlayerKickOperationOrchestrator.sendDiscord(con);
	}
}
