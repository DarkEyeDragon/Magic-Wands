package me.darkeyedragon.magicwands.events;

import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.casting.animations.ShortCastAnimation;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WandRightClickEvent implements Listener{

    @EventHandler
    public void onPlayerRightClick (PlayerInteractEvent e){
        if (!(e.getAction() == Action.LEFT_CLICK_AIR)){
            return;
        }
        Player p = e.getPlayer();
        ItemStack itemStack = p.getInventory().getItemInMainHand();
        NBTItem item = new NBTItem(itemStack);
        if (itemStack.getType() == Material.STICK && item.hasKey(WandBase.IS_WAND)){
            Spell spell = new Confringo(p);
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
            }
        }
    }
}
