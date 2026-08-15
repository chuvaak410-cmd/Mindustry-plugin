package agzam4.bot.strategy;

import agzam4.bot.Bots;
import agzam4.bot.TSender;
import agzam4.bot.TUser;
import agzam4.bot.TUser.MessageData;
import arc.util.CommandHandler.ResponseType;
import mindustry.gen.Call;

/** Default {@link ITUserMessageHandlingStrategy}, mirroring the original {@code TUser.onMessage} logic exactly. */
public class TUserMessageHandlingStrategyImpl implements ITUserMessageHandlingStrategy {

	@Override
	public void handle(TUser user, TSender sender, String message) {
		if(sender.ignore()) return;
		if(message.startsWith("/")) {
			MessageData data = new MessageData();
			data.user = user;
			data.chat = sender;
			var response = Bots.handler.handleMessage(message, data);
			if(response.type == ResponseType.valid) return;
			if(response.type == ResponseType.noCommand) {
				sender.message("не команда найдена");
				return;
			}
			if(response.type == ResponseType.manyArguments) {
				sender.message("Слишком много аргументов");
				return;
			}
			if(response.type == ResponseType.fewArguments) {
				sender.message("Слишком мало аргументов");
				return;
			}
			if(response.type == ResponseType.unknownCommand) {
				sender.message("Команда не найдена");
				return;
			}
			sender.message(":(");
			return;
		}
		if(user == sender && user.hasPermission("server-say")) {
			Call.sendMessage(message);
			return;
		}
		if(user == sender) sender.message("Type /help for more");
	}
}
