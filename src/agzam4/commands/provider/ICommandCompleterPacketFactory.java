package agzam4.commands.provider;

import agzam4.commands.CommandCompleterPacket;

/** Factory contract producing {@link CommandCompleterPacket} instances. */
public interface ICommandCompleterPacketFactory {

	CommandCompleterPacket create();
}
