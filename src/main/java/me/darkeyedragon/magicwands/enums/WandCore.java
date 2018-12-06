package me.darkeyedragon.magicwands.enums;

/*
 * CORES Explained:
 * UNICORN: Reliable, Loyal, can only be wielded by the owner, weakest
 * DRAGON: Most Powerful, potentially unstable, fast learner
 * PHOENIX: Rarest, wide range in magic, slow learning, may reject owner
 *
 * Rarity: Lower is more common.
 * */

public enum WandCore{
    UNICORN(0.30), DRAGON(0.50), PHOENIX(0.90);

    private double rarity;

    WandCore (double rarity){
        this.rarity = rarity;
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

    public static String getWandCoresAsString (){
        StringBuilder builder = new StringBuilder();
        for (WandCore wc : WandCore.values()){
            builder.append(wc.toString());
            builder.append(" ");
        }
        return builder.toString();
    }
}
