package me.darkeyedragon.magicwands.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.enums.WandCore;
import me.darkeyedragon.magicwands.enums.WandWood;
import me.darkeyedragon.magicwands.wands.WandBase;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.ChatColor.*;


@CommandAlias ("magicwands|mw|magicwand")
public class WandInfoCommand extends BaseCommand{
    public WandInfoCommand (Magicwands magicwands){

    }

    @Subcommand ("info")
    @Description ("Get the info of the wand in your hand")
    @CommandPermission ("magicwands.user")
    public void giveWand (Player player, String[] args){
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        NBTItem nbtItem = new NBTItem(itemStack);
        String coreNBT = nbtItem.getString(WandBase.WAND_CORE_NBT);
        String woodNBT = nbtItem.getString(WandBase.WAND_WOOD_NBT);
        if (WandCore.isWandCore(coreNBT)){
            WandCore wandCore = Objects.requireNonNull(WandCore.getWandCore(coreNBT));
            WandWood wandWood = Objects.requireNonNull(WandWood.getWandWood(woodNBT));
            player.sendMessage(AQUA + "============== " + GOLD + "Core " + AQUA + "==============");
            player.sendMessage(GREEN + "Core name: " + wandCore.name());
            player.sendMessage(GREEN + "Core damage: " + wandCore.getBaseDamage());
            player.sendMessage(GREEN + "Core rarity: " + wandCore.getRarity());
            player.sendMessage(GREEN + "Core stability: " + wandCore.getStability());
            player.sendMessage(AQUA + "=========== " + GOLD + "Wand Wood " + AQUA + "============");
            player.sendMessage(GREEN + "Wood name: " + wandWood.name());
            player.sendMessage(GREEN + "Wood power multiplier: " + wandWood.getPower());
            player.sendMessage(GREEN + "Wood rarity: " + wandWood.getRarity());
            player.sendMessage(GREEN + "Wood stability: " + wandWood.getStability());
        }else{
            player.sendMessage(RED + "The item in your hand is not a valid wand!");
        }
    }
}
