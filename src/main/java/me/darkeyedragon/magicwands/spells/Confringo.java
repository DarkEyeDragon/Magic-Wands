package me.darkeyedragon.magicwands.spells;


import com.destroystokyo.paper.ParticleBuilder;
import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.enums.WandCore;
import me.darkeyedragon.magicwands.enums.WandWood;
import me.darkeyedragon.magicwands.wands.WandBase;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

/*
 * Creates Wave of heat
 * */
public class Confringo extends Spell{

    private double coreDamage;
    private double woodMultiplier;
    private Spell spell;

    public Confringo (Player player){
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        NBTItem nbtItem = new NBTItem(itemStack);
        boolean hasKey = nbtItem.hasKey(WandBase.IS_WAND);
        if (hasKey){
            WandWood wandWood = WandWood.getWandWood(nbtItem.getString(WandBase.WAND_WOOD_NBT));
            if (wandWood != null){
                woodMultiplier = wandWood.getPower();
            }
            WandCore wandCore = WandCore.getWandCore(nbtItem.getString(WandBase.WAND_CORE_NBT));
            if (wandCore != null){
                coreDamage = wandCore.getBaseDamage();
            }
        }
    }

    private void damageEntity (Entity entity){
        if (entity instanceof LivingEntity){
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.damage(coreDamage * woodMultiplier);
            System.out.println(coreDamage * woodMultiplier + "core damage:" + coreDamage);
        }
    }

    @Override
    public void spawnParticles (Location location, int count){
        super.spawnParticles(location, count);
        ParticleBuilder particleBuilder = new ParticleBuilder(Particle.FLAME);
        particleBuilder.count(count).allPlayers();
        new BukkitRunnable(){
            double t = 0;
            double r = 0.2;
            int count = 0;

            @Override
            public void run (){
                List<Entity> entities;
                t += Math.PI / 8;
                double x = r * Math.cos(t);
                double z = r * Math.sin(t);
                location.add(x, 1.2, z).add(location.getDirection());
                particleBuilder.location(location);
                particleBuilder.spawn();
                if (count > 4){
                    entities = (List<Entity>) location.getNearbyEntities(2, 2, 2);
                    entities.forEach((v) -> damageEntity(v));
                    count = 0;
                }
                count++;
                location.subtract(x, 1.2, z);
                if (t > Math.PI * 8){
                    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.EXPLOSION_NORMAL);
                    particleBuilder.location(location);
                    particleBuilder.spawn();
                    this.cancel();
                }

            }
        }.runTaskTimer(Magicwands.getPlugin(Magicwands.class), 0, 0);
    }
}
