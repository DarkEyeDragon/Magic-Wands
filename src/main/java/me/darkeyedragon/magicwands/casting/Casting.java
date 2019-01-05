package me.darkeyedragon.magicwands.casting;

public abstract class Casting{

    private long initialCost = 50;
    private long castingCost = 1;

    //Casting time in ticks
    private long castingTime = 20;

    public long getInitialCost (){
        return initialCost;
    }

    public void setInitialCost (long initialCost){
        this.initialCost = initialCost;
    }

    public long getCastingCost (){
        return castingCost;
    }

    public void setCastingCost (long castingCost){
        this.castingCost = castingCost;
    }

    public long getCastingTime (){
        return castingTime;
    }

    public void setCastingTime (long castingTime){
        this.castingTime = castingTime;
    }
}
