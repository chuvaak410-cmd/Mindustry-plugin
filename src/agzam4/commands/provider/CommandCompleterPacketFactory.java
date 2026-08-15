package agzam4.commands.provider;

import agzam4.commands.CommandCompleterPacket;

/** Default {@link ICommandCompleterPacketFactory}, delegating to the unchanged constructor. */
public class CommandCompleterPacketFactory implements ICommandCompleterPacketFactory {

	@Override
	public CommandCompleterPacket create() {
		return new CommandCompleterPacket();
	}
}
