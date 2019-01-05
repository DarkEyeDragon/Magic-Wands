package me.darkeyedragon.magicwands.casting.animations;

import com.destroystokyo.paper.ParticleBuilder;
import me.darkeyedragon.magicwands.Magicwands;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class ShortCastAnimation{

    private Location location;

    public ShortCastAnimation (Location location){
        this.location = location;
    }

    public void play (){
        ParticleBuilder particleBuilder = new ParticleBuilder(Particle.SPELL_INSTANT);
        new BukkitRunnable(){
            Location loc = location.clone();
            double t = 0;
            double r = 1;

            @Override
            public void run (){
                Location newLoc = loc.clone().add(0, 1.2, 0).add(location.getDirection());
                particleBuilder.location(newLoc);
                particleBuilder.count(0);
                particleBuilder.spawn();
                this.cancel();
            }
        }.runTaskTimer(Magicwands.getPlugin(Magicwands.class), 5, 1);
    }
}
