package me.darkeyedragon.magicwands.spells;

/*
 * Slow down and obstruct attackers
 * */

import me.darkeyedragon.magicwands.animations.Ray;
import org.bukkit.Location;

public class Impedimenta extends Spell{

    private Ray ray;

    @Override
    public void spawnParticles (Location location, int count){
        super.spawnParticles(location, count);
        ray = new Ray(location, count);
        ray.spawn();
    }

    public Ray getRay (){
        return ray;
    }
}
