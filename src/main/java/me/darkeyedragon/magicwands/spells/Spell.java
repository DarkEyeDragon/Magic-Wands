package me.darkeyedragon.magicwands.spells;

import org.bukkit.Location;

public class Spell implements IBasicSpell{

    @Override
    public String toString (){
        return this.getClass().getName();
    }

    @Override
    public void spawnParticles (Location location, int count){

    }
}
