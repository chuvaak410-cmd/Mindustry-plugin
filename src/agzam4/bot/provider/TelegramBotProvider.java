package agzam4.bot.provider;

import agzam4.bot.TelegramBot;

/** Default {@link ITelegramBotProvider}, delegating to the unchanged {@link TelegramBot} statics. */
public class TelegramBotProvider implements ITelegramBotProvider {

	@Override
	public void initialize() {
		TelegramBot.init();
	}

	@Override
	public void load() {
		TelegramBot.load();
	}

	@Override
	public void save() {
		TelegramBot.save();
	}

	@Override
	public void stop() {
		TelegramBot.stop();
	}

	@Override
	public String strip(String text) {
		return TelegramBot.strip(text);
	}
}
