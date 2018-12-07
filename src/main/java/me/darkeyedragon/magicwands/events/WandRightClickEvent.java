package me.darkeyedragon.magicwands.events;

import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.spells.Confringo;
import me.darkeyedragon.magicwands.spells.Spell;
import me.darkeyedragon.magicwands.wands.WandBase;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WandRightClickEvent implements Listener{

    @EventHandler
    public void onPlayerRightClick (PlayerInteractEvent e){
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR)){
            return;
        }
        Player p = e.getPlayer();
        ItemStack itemStack = p.getInventory().getItemInMainHand();
        NBTItem item = new NBTItem(itemStack);
        if (itemStack.getType() == Material.STICK && item.hasKey(WandBase.IS_WAND)){
            Spell spell = new Confringo(p);
            if (Magicwands.recentlyCast.containsKey(p)){
                Spell spell1 = Magicwands.recentlyCast.get(p);
                if (spell1.lastCast + 1000 < System.currentTimeMillis()){
                    System.out.println("OK:" + spell1.lastCast);
                    spell.spawnParticles(p.getLocation(), 0);
                    System.out.println(spell.lastCast);
                    Magicwands.recentlyCast.remove(p);
                    Magicwands.recentlyCast.put(p, spell);
                }else{
                    p.sendMessage("You recently cast a spell!");
                }
            }else{
                spell.spawnParticles(p.getLocation(), 0);
                Magicwands.recentlyCast.put(p, spell);
            }
        }
    }
}
