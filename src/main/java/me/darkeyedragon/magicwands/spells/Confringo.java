package me.darkeyedragon.magicwands.spells;


import com.destroystokyo.paper.ParticleBuilder;
import me.darkeyedragon.magicwands.Magicwands;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

/*
 * Creates Wave of heat
 * */
public class Confringo extends Spell{

    @Override
    public void spawnParticles (Location location, int count){
        ParticleBuilder particleBuilder = new ParticleBuilder(Particle.FLAME);
        particleBuilder.count(count).allPlayers();
        new BukkitRunnable(){
            @Override
            public void run (){
                particleBuilder.location(location.add(location.getDirection()));
                particleBuilder.spawn();
            }
        }.runTaskTimer(Magicwands.getPlugin(Magicwands.class), 0, 200);
    }
}
