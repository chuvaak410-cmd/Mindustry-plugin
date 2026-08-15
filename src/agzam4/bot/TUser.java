package agzam4.bot;

import agzam4.CommandsManager.CommandSender;
import agzam4.bot.strategy.ITUserMessageHandlingStrategy;
import agzam4.bot.strategy.TUserMessageHandlingStrategyImpl;
import agzam4.utils.ApplicationDiagnosticMessageGateway;

import java.io.IOException;

import arc.util.serialization.JsonValue;
import arc.util.serialization.JsonWriter;
import arc.util.Nullable;

public class TUser extends TSender {

	private static final ITUserMessageHandlingStrategy messageHandlingStrategy = new TUserMessageHandlingStrategyImpl();

	public String name = "user";
	
	public TUser(long id) {
		super(id);
	}
	
	public TUser(JsonValue json) {
		super(json);
		name = json.getString("name", name);
	}
	
	@Override
	protected void write(JsonWriter writer) throws IOException {
		super.write(writer);
		writer.set("name", name);
	}
	
	public void onMessage(TSender sender, String message) {
		messageHandlingStrategy.handle(this, sender, message);
	}

	public static @Nullable TUser read(String data) {
		try {
			String[] args = data.split(" ");
			return new TUser(TSender.id(args[0]));
		} catch (Exception e) {
		}
		return null;
	}

	
	public static class MessageData implements CommandSender {
		
		public TUser user;
		public TSender chat;
		
		@Override
		public void sendMessage(String message) {
			chat.message(message);
		}

		public void noAccess(String command) {
			chat.message("Нет доступа к " + command);
		}

		public boolean hasPermissions(String permission) {
			if(!chat.hasPermission(permission)) return false;
			if(user.hasOnlyChatPermission(permission)) {
				ApplicationDiagnosticMessageGateway.info("Checking [blue]only-chat @[] @ ([gray]@[] != [gray]@[])", permission, user != chat, user.uid(), chat.uid());
				return user != chat;
			}
			return user.hasPermission(permission);
		}
		
	}
	
}
