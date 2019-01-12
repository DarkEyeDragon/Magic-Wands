package me.darkeyedragon.magicwands.spell;

import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.Wand;
import me.darkeyedragon.magicwands.casting.animations.SpellAnimation;
import me.darkeyedragon.magicwands.wrappers.PlayerWithMana;
import org.bukkit.entity.Player;

public class Spell{
    private final PlayerWithMana CASTER;
    private final int MANA_COST;
    private final int BASE_DAMAGE;
    private final SpellAnimation SPELL_ANIMATION;
    private final Wand WAND;

    public Spell (Player caster, int manaCost, int baseDamage, SpellAnimation spellAnimation, Wand wand){
        CASTER = Magicwands.manaMap.get(caster.getUniqueId());
        MANA_COST = manaCost;
        BASE_DAMAGE = baseDamage;
        SPELL_ANIMATION = spellAnimation;
        WAND = wand;
    }

    public PlayerWithMana getCaster (){
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

    public Wand getWand (){
        return WAND;
    }
}
