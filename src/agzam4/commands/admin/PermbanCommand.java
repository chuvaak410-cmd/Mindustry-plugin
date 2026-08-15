package agzam4.commands.admin;

import agzam4.game.MindustryGameRuntimeFacade;
import agzam4.CommandsManager.CommandSender;
import agzam4.CommandsManager.ReceiverType;
import agzam4.commands.CommandHandler;
import mindustry.Vars;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerInfo;

public class PermbanCommand extends CommandHandler<Player> {
    {
        desc = "Permanently ban player (forever)";
        parms = "<ID/Name> BY SPIXUN";
    }

    @Override
    public void command(String[] args, CommandSender sender, Player receiver, ReceiverType type) {
        if(args.length < 1){
            sender.sendMessage("[red]Usage: /permban <ID/Name>");
            return;
        }
        
        String target = args[0];
        PlayerInfo info = null;
        Player onlinePlayer = MindustryGameRuntimeFacade.findPlayer(target);
        if(onlinePlayer != null){
            info = onlinePlayer.getInfo();
        }
        if(info == null){
            info = Vars.netServer.admins.getInfoOptional(target);
        }
        if(info == null){
            for(PlayerInfo pInfo : Vars.netServer.admins.playerInfo.values()){
                if(pInfo.plainLastName().equalsIgnoreCase(target) || MindustryGameRuntimeFacade.strip(pInfo.lastName).equalsIgnoreCase(target)){
                    info = pInfo;
                    break;
                }
            }
        }
        if(info == null){
            sender.sendMessage("[red]Player not found.");
            return;
        }

        info.banned = true;
        Vars.netServer.admins.banPlayerID(info.id);
        if(info.lastIP != null){
            Vars.netServer.admins.banPlayerIP(info.lastIP);
        }
        
        if(onlinePlayer != null){
            onlinePlayer.kick("[scarlet]You have been permanently banned.");
        }
        
        sender.sendMessage("[green]Player " + info.plainLastName() + " has been permanently banned.");
    }
}
