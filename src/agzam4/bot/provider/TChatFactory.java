package agzam4.bot.provider;

import agzam4.bot.TChat;

/** Default {@link ITChatFactory}, delegating to the unchanged {@link TChat} constructor. */
public class TChatFactory implements ITChatFactory {

	@Override
	public TChat create(long id) {
		return new TChat(id);
	}
}
