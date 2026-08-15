package agzam4.provider;

/** Delegating contract over the {@link agzam4.utils.UnicodeEmoticonResolutionProvider} constant table. */
public interface IEmojiProvider {

	char[] oreBlocksEmoji();

	char[] liquidsEmoji();

	char alert();
}
