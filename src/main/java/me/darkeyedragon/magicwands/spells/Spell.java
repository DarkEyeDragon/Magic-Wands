package me.darkeyedragon.magicwands.spells;

import org.bukkit.Location;

public class Spell implements IBasicSpell{

    public long lastCast;

    @Override
    public String toString (){
        return this.getClass().getSimpleName();
    }

    @Override
    public void spawnParticles (Location location, int count){
        lastCast = System.currentTimeMillis();
    }


}
