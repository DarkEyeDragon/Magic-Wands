package me.darkeyedragon.magicwands.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@CommandAlias ("magicwands|mw|magicwand")
public class CreateWandCommand extends BaseCommand{

    private final Plugin plugin;

    public CreateWandCommand (Plugin plugin){
        this.plugin = plugin;
    }

    @Subcommand ("give")
    @Description ("Give the player a basic wand")
    @CommandPermission ("magicwands.admin")
    public void giveWand (Player player, String[] args){
        /*WandBase wandBase;
        if (args.length > 0){
            if (WandCore.isWandCore(args[0])){
                wandBase = new WandBase(args[0], Objects.requireNonNull(WandCore.getWandCore(args[0])), WandWood.ASH);
                wandBase.bindSpell(new Confringo(player));
                wandBase.give(player);
            }else{
                player.sendMessage(ChatColor.RED + args[0] + " is not a valid core!");
                player.sendMessage("Valid cores are: " + WandCore.getWandCoresAsString());
            }
        }*/
    }
}
