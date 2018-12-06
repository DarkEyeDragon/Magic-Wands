package me.darkeyedragon.magicwands.enums;

import me.darkeyedragon.magicwands.spells.Confringo;
import me.darkeyedragon.magicwands.spells.Spell;

public enum Spells{
    CONFRINGO(new Confringo());

    private Spell spell;

    Spells (Spell spell){
        this.spell = spell;
    }

    public Spell getSpell (){
        return spell;
    }
}
