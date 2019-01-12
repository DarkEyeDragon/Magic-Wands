package me.darkeyedragon.magicwands.eventHandlers;

import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.event.SpellCastEvent;
import me.darkeyedragon.magicwands.spell.Spell;
import me.darkeyedragon.magicwands.wrappers.PlayerWithMana;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SpellCastEventHandler implements Listener{

    @EventHandler
    public void onSpellCast (SpellCastEvent e){
        Spell spell = e.getSpell();
        PlayerWithMana playerWithMana = spell.getCaster();
        Player player = playerWithMana.getPlayer();
        int manaDrain = spell.getCaster().getCurrentMana() - spell.getManaCost();
        if (manaDrain < 0){
            e.setCancelled(true);
            player.sendMessage("You don't have enough mana to cast this spell!");
        }else{
            playerWithMana = Magicwands.getManaMap().get(player.getUniqueId());
            playerWithMana.setCurrentMana(spell.getManaCost());
        }
    }
}
