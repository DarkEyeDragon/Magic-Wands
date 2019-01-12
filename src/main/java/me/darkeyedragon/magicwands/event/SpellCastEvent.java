package me.darkeyedragon.magicwands.event;

import me.darkeyedragon.magicwands.spell.Spell;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpellCastEvent extends Event{

    private static final HandlerList handlers = new HandlerList();
    private Spell spell;
    private boolean cancelled;

    public SpellCastEvent (Spell spell){
        this.spell = spell;
    }

    public boolean isCancelled (){
        return cancelled;
    }

    public void setCancelled (boolean cancel){
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers (){
        return handlers;
    }

    public static HandlerList getHandlerList (){
        return handlers;
    }
    public Spell getSpell (){
        return spell;
    }
}
