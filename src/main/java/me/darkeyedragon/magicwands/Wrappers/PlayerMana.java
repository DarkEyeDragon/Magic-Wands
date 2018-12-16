package me.darkeyedragon.magicwands.Wrappers;

import org.bukkit.entity.Player;

public class PlayerMana{

    private Player player;
    private double mana;
    private double maxMana;

    public PlayerMana (Player player){
        this(player, 20, 20);
    }

    public PlayerMana (Player player, double mana){
        this(player, mana, mana);
    }

    public PlayerMana (Player player, double maxMana, double currentMana){
        this.player = player;
        this.mana = currentMana;
        this.maxMana = maxMana;
    }

    public boolean removeMana (double amount){
        if (amount < maxMana && amount < mana){
            mana -= amount;
            return true;
        }else{
            return false;
        }
    }

    public void addMana (double amount){
        mana += amount;
    }

    public Player getPlayer (){
        return player;
    }

    public void setPlayer (Player player){
        this.player = player;
    }

    public double getMana (){
        return mana;
    }

    public void setMana (double mana){
        this.mana = mana;
    }

    public double getMaxMana (){
        return maxMana;
    }

    public void setMaxMana (double maxMana){
        this.maxMana = maxMana;
    }
}
