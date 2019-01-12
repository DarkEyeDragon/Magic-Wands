package me.darkeyedragon.magicwands.events.custom;

import me.darkeyedragon.magicwands.spell.Spell;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpellCastEvent extends Event{

    private static final HandlerList handlers = new HandlerList();
    private Spell spell;

    public SpellCastEvent (Spell spell){
        this.spell = spell;
    }

    @Override
    public HandlerList getHandlers (){
        return handlers;
    }

    public Spell getSpell (){
        return spell;
    }
}
