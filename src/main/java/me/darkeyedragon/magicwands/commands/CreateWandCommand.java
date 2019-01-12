package me.darkeyedragon.magicwands.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import me.darkeyedragon.magicwands.Wand;
import me.darkeyedragon.magicwands.enums.WandCore;
import me.darkeyedragon.magicwands.enums.WandWood;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
        Wand wand;
        if (args.length > 0){
            if (WandWood.isWandWood(args[0]) && WandCore.isWandCore(args[1])){
                wand = new Wand(WandWood.getWandWood(args[0]), WandCore.getWandCore(args[1]), new ItemStack(Material.STICK));
                wand.bindSpell(null);
                player.getInventory().addItem(wand.getItem());
            }else{
                player.sendMessage(ChatColor.RED + args[0] + " is not a valid wand!");
                player.sendMessage("Valid cores are: " + WandCore.getAsString());
                player.sendMessage("Valid woods are: " + WandWood.getAsString());
            }
        }else{
            wand = new Wand(new ItemStack(Material.STICK));
            player.getInventory().addItem(wand.getItem());
        }
    }
}
