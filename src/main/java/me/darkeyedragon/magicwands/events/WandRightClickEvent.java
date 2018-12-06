package me.darkeyedragon.magicwands.events;

import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.spells.Confringo;
import me.darkeyedragon.magicwands.spells.Spell;
import me.darkeyedragon.magicwands.wands.WandBase;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WandRightClickEvent implements Listener{
    public void onPlayerRightClick (PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack itemStack = p.getInventory().getItemInMainHand();
        NBTItem item = new NBTItem(itemStack);
        if (itemStack.getType() == Material.STICK && item.hasKey(WandBase.IS_WAND)){
            Spell spell = new Confringo();
            spell.spawnParticles(p.getLocation(), 20);
        }
    }
}
