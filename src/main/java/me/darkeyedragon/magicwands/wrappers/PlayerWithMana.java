package me.darkeyedragon.magicwands.wrappers;

import org.bukkit.entity.Player;

public class PlayerWithMana{

    public static final int DEFAULT_MAX_MANA = 20;

    private Player player;
    private int maxMana;
    private int currentMana;

    public PlayerWithMana (){
        this(null, DEFAULT_MAX_MANA);
    }

    public PlayerWithMana (Player player){
        this(player, DEFAULT_MAX_MANA);
    }

    public PlayerWithMana (Player player, int maxMana){
        this.player = player;
        this.maxMana = maxMana;
    }

    public Player getPlayer (){
        return player;
    }

    public void setPlayer (Player player){
        this.player = player;
    }

    public int getMaxMana (){
        return maxMana;
    }

    public void setMaxMana (int maxMana){
        this.maxMana = maxMana;
    }

    public int getCurrentMana (){
        return currentMana;
    }

    public void setCurrentMana (int currentMana){
        this.currentMana = currentMana;
    }
}
