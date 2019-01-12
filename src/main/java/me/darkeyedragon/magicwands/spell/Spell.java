package me.darkeyedragon.magicwands.spell;

import me.darkeyedragon.magicwands.casting.animations.SpellAnimation;
import org.bukkit.entity.Player;

public class Spell{
    private final Player CASTER;
    private final int MANA_COST;
    private final int BASE_DAMAGE;
    private final SpellAnimation SPELL_ANIMATION;

    public Spell (Player caster, int manaCost, int baseDamage, SpellAnimation spellAnimation){
        CASTER = caster;
        MANA_COST = manaCost;
        BASE_DAMAGE = baseDamage;
        SPELL_ANIMATION = spellAnimation;
    }

    public Player getCaster (){
        return CASTER;
    }

    public int getManaCost (){
        return MANA_COST;
    }

    public int getBaseDamage (){
        return BASE_DAMAGE;
    }

    public SpellAnimation getSpellAnimation (){
        return SPELL_ANIMATION;
    }
}
