package me.darkeyedragon.magicwands;

import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.enums.WandCore;
import me.darkeyedragon.magicwands.enums.WandWood;
import me.darkeyedragon.magicwands.spell.Spell;
import org.bukkit.inventory.ItemStack;

public class Wand{
    private WandWood wandWood;
    private WandCore wandCore;
    private ItemStack itemStack;

    public static final String SPELL_NBT = "spell";

    public Wand (WandWood wandWood, WandCore wandCore, ItemStack itemStack){
        this.wandWood = wandWood;
        this.wandCore = wandCore;
        this.itemStack = itemStack;
    }

    /**
     * @param itemStack
     */
    public Wand (ItemStack itemStack){
        this(WandWood.getRandom(), WandCore.getRandom(), itemStack);
    }

    public void bindSpell (Spell spell){
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setObject(SPELL_NBT, spell);
        itemStack = nbtItem.getItem();
    }

    public ItemStack getItem (){
        return itemStack;
    }
}
