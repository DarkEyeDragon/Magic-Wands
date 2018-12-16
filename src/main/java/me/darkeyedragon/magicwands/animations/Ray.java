package me.darkeyedragon.magicwands.animations;

import com.destroystokyo.paper.ParticleBuilder;
import me.darkeyedragon.magicwands.Magicwands;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class Ray{

    private ParticleBuilder particleBuilder;
    private int count = 0;
    private Location location;
    private int distance;

    public Ray (Location location, int distance){
        this.location = location;
        this.distance = distance;
        particleBuilder = new ParticleBuilder(Particle.REDSTONE);
    }

    public void spawn (){
        new BukkitRunnable(){
            @Override
            public void run (){
                location.add(location.getDirection());
                particleBuilder.location(location);
                particleBuilder.spawn();
                if (count > distance){
                    this.cancel();
                }
                count++;
                //location.subtract(location.getDirection());
            }
        }.runTaskTimer(Magicwands.getPlugin(Magicwands.class), 0, 1);
    }
}
