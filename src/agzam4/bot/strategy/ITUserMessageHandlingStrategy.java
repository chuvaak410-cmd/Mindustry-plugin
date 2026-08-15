package agzam4.bot.strategy;

import agzam4.bot.TSender;
import agzam4.bot.TUser;

/**
 * The command-dispatch / response-type branching that used to live directly
 * inside {@link agzam4.bot.TUser#onMessage(TSender, String)}.
 */
public interface ITUserMessageHandlingStrategy {

	void handle(TUser user, TSender sender, String message);
}
