package agzam4.provider;

import agzam4.utils.UnicodeEmoticonResolutionProvider;

/** Default {@link IEmojiProvider}, delegating to the unchanged {@link UnicodeEmoticonResolutionProvider} constants. */
public class EmojiProvider implements IEmojiProvider {

	@Override
	public char[] oreBlocksEmoji() {
		return UnicodeEmoticonResolutionProvider.oreBlocksEmoji;
	}

	@Override
	public char[] liquidsEmoji() {
		return UnicodeEmoticonResolutionProvider.liquidsEmoji;
	}

	@Override
	public char alert() {
		return UnicodeEmoticonResolutionProvider.emojiAlert;
	}
}
