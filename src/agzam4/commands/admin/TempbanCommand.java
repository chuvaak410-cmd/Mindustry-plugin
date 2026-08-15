package agzam4.commands.admin;

import agzam4.game.MindustryGameRuntimeFacade;
import agzam4.CommandsManager.CommandSender;
import agzam4.CommandsManager.ReceiverType;
import agzam4.commands.CommandHandler;
import arc.util.Time;
import mindustry.Vars;
import mindustry.gen.Groups;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerInfo; //мне впадлу каждый раз переключать с английского на русский сори сам локаризируешь ;) дай админку пж мне снайпер сказал что с тобой поговрит ;) я крч жду ответа и че ты сказал что я тебе угрожал когда я тебе угрожал и как. все давай ._.
public class TempbanCommand extends CommandHandler<Player> {
    {
        desc = "Ban player for specified time in minutes";
        parms = "<ID/Name> <Minutes>";
    }
    @Override
    public void command(String[] args, CommandSender sender, Player receiver, ReceiverType type) {
        sender.sendMessage("[accent]PLUGIN BY SPIXUN (plz adm)");
        if(args.length < 2){
            sender.sendMessage("[red]Usage: /tempban <ID/Name> <Minutes>");
            return;
        }
        int minutes;
        try{
            minutes = Integer.parseInt(args[1]);
        }catch(NumberFormatException e){
            sender.sendMessage("[red]Minutes must be a number.");
            return;
        }
        if(minutes <= 0){
            sender.sendMessage("[red]Minutes must be greater than 0.");
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

        long expireTime = Time.millis() + ((long)minutes * 60L * 1000L);
        info.lastKicked = expireTime;
        if(info.lastIP != null){
            Vars.netServer.admins.kickedIPs.put(
                info.lastIP,
                expireTime
            );
        }
        if(onlinePlayer != null){
            onlinePlayer.kick(
                "[scarlet]You have been temporarily banned for "
                + minutes +
                " minute(s)."
            );
        }
        sender.sendMessage(
            "[green]Player "
            + info.plainLastName()
            + " has been banned for "
            + minutes
            + " minute(s)."
        );
    }
}
