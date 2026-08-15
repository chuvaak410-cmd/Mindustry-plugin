package agzam4.io.provider;

import java.nio.ByteBuffer;

import agzam4.io.ByteBufferIO;

/** Default {@link IByteBufferIOProvider}, delegating to the unchanged {@link ByteBufferIO} statics. */
public class ByteBufferIOProvider implements IByteBufferIOProvider {

	@Override
	public void writeString(ByteBuffer buffer, String string) {
		ByteBufferIO.writeString(buffer, string);
	}

	@Override
	public String readString(ByteBuffer buffer) {
		return ByteBufferIO.readString(buffer);
	}
}
