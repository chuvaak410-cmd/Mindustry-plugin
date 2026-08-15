package agzam4.io.provider;

import java.nio.ByteBuffer;

/** Delegating contract over the static {@link agzam4.io.ByteBufferIO} helpers. */
public interface IByteBufferIOProvider {

	void writeString(ByteBuffer buffer, String string);

	String readString(ByteBuffer buffer);
}
