package me.darkeyedragon.magicwands.eventHandlers;

import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.Wand;
import me.darkeyedragon.magicwands.event.SpellCastEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WandClickEventHandler implements Listener{

    @EventHandler
    public void onPlayerRightClick (PlayerInteractEvent e){
        if (!(e.getAction() == Action.LEFT_CLICK_AIR)){
            return;
        }
        Player p = e.getPlayer();
        ItemStack itemStack = p.getInventory().getItemInMainHand();
        NBTItem item = new NBTItem(itemStack);

        //TODO generate spell depending on meta data
        SpellCastEvent spellCastEvent = new SpellCastEvent(null);
        Bukkit.getServer().getPluginManager().callEvent(spellCastEvent);
        if (spellCastEvent.isCancelled()){
            return;
        }
        if (itemStack.getType() == Material.STICK && item.hasKey(Wand.SPELL_NBT)){
            /*Spell spell = new Confringo(p);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20, 5));
            ShortCastAnimation shortCastAnimation = new ShortCastAnimation(p.getLocation());
            shortCastAnimation.play();
            if (Magicwands.recentlyCast.containsKey(p)){
                Spell spell1 = Magicwands.recentlyCast.get(p);
                if (spell1.lastCast + 1000 < System.currentTimeMillis()){
                    spell.spawnParticles(p.getLocation(), 0);
                    Magicwands.recentlyCast.remove(p);
                    Magicwands.recentlyCast.put(p, spell);
                }else{
                    p.sendMessage("You recently cast a spell!");
                }
            }else{
                spell.spawnParticles(p.getLocation(), 0);
                Magicwands.recentlyCast.put(p, spell);
            }*/
        }
    }
}
