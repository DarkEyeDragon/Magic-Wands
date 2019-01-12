package me.darkeyedragon.magicwands.enums;

/*
 * CORES Explained:
 * UNICORN: Reliable, Loyal, can only be wielded by the owner, weakest
 * DRAGON: Most Powerful, potentially unstable, fast learner
 * PHOENIX: Rarest, wide range in magic, slow learning, may reject owner
 *
 * Rarity: Lower is more common.
 * */

import java.util.Random;

public enum WandCore{

    UNICORN(0.30, 1, 5 * 1.2), DRAGON(0.50, 0.5, 5 * 2.8), PHOENIX(0.90, 1, 5 * 1.1);

    private double rarity;
    private double baseDamage;
    private double stability;
    private static Random random = new Random();

    WandCore (double rarity, double stability, double baseDamage){
        this.rarity = rarity;
        this.baseDamage = baseDamage;
        this.stability = stability;
    }

    public static boolean isWandCore (String name){
        for (WandCore wc : WandCore.values()){
            if (wc.toString().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public static WandCore getWandCore (String name){
        for (WandCore wc : WandCore.values()){
            if (wc.toString().equalsIgnoreCase(name)){
                return wc;
            }
        }
        return null;
    }

    public static String getAsString (){
        StringBuilder builder = new StringBuilder();
        for (WandCore wc : WandCore.values()){
            builder.append(wc.toString());
            builder.append(" ");
        }
        return builder.toString();
    }

    public static WandCore getRandom (){
        int num = random.nextInt(WandCore.values().length);
        return WandCore.values()[num];
    }

    public double getRarity (){
        return rarity;
    }

    public double getBaseDamage (){
        return baseDamage;
    }

    public double getStability (){
        return stability;
    }
}
