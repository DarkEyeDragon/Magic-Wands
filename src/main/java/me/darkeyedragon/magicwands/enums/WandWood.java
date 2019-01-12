package me.darkeyedragon.magicwands.enums;

import java.util.Random;

/*
 * https://www.pottermore.com/writing-by-jk-rowling/wand-woods
 */
//TODO test if combining with WandCore will not make certain types OP
public enum WandWood{
    ACACIA(0.15, 1, 0.75, true), ALDER(0.8, 0.8, 0.5, false), APPLE(0.3, 1, 0.6, false), ASH(0.8, 1, 0.3, true), ASPEN(0.9, 1, 0.8, false), BEECH(0.8, 0.8, 85, false), BLACKTHORN(0.12, 1, 0.71, true), BLACK_WALNUT(0.5, 0.8, 0.3, false), CEDAR(0.25, 1, 0.75, false), CHERRY(0.1, 0.7, 0.81, false), CHESTNUT(0.5, 1, 0.66, false), CYPRESS(0.30, 1, 0.6, false),
    DOGWOOD(0.30, 1, 0.45, false), EBONY(0.6, 1, 0.3, false), ELDER(0.01, 0.6, 1.2, true), ELM(0.2, 1, 0.79, false), ENGLISH_OAK(0.8, 1, 0.65, false), FIR(0.6, 1, 0.35, false), HAWTHORN(0.56, 0.3, 0.32, false)/*, HAZEL, HOLLY, HORNBEAM, LARCH, LAUREL, MAPLE,
    PEAR, PINE, POPLAR, RED_OAK, REDWOOD, ROWAN, SILVER_LIME, SPRUCE, SYCAMORE, VINE, WALNUT, WILLOW, YEW*/;


    double rarity;
    double stability;
    double power;
    boolean permanentOwner;

    private static Random random = new Random();

    WandWood (double rarity, double stability, double power, boolean permanentOwner){
        this.rarity = rarity;
        this.stability = stability;
        this.power = power;
        this.permanentOwner = permanentOwner;
    }

    public static WandWood getWandWood (String name){
        for (WandWood ww : WandWood.values()){
            if (ww.toString().equalsIgnoreCase(name)){
                return ww;
            }
        }
        return null;
    }

    public static boolean isWandWood (String name){
        for (WandWood ww : WandWood.values()){
            if (ww.toString().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public double getRarity (){
        return rarity;
    }

    public double getStability (){
        return stability;
    }

    public double getPower (){
        return power;
    }

    public boolean isPermanentOwner (){
        return permanentOwner;
    }

    public static WandWood getRandom (){
        int num = random.nextInt(WandWood.values().length);
        return WandWood.values()[num];
    }

    public static String getAsString (){
        StringBuilder builder = new StringBuilder();
        for (WandWood ww : WandWood.values()){
            builder.append(ww.toString());
            builder.append(" ");
        }
        return builder.toString();
    }
}
