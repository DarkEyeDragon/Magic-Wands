package me.darkeyedragon.magicwands.wands;

import de.tr7zw.itemnbtapi.NBTItem;
import me.darkeyedragon.magicwands.enums.WandCore;
import me.darkeyedragon.magicwands.enums.WandWood;
import me.darkeyedragon.magicwands.spells.Spell;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class WandBase{

    /*Define the NBT names*/
    public static final String WAND_WOOD_NBT = "wand_wood";
    public static final String WAND_CORE_NBT = "wand_core";
    public static final String WAND_SPELL_NBT = "bound_spells";
    public static final String IS_WAND = "is_wand";

    private String displayName;
    private WandCore wandCore;
    private WandWood wandWood;
    private ItemStack itemStack;
    private List<String> loreList;
    private Spell boundSpell;
    NBTItem nbtItem;

    public WandBase (String displayName, WandCore wandCore, WandWood wandWood){
        this.displayName = displayName;
        this.wandCore = wandCore;
        loreList = new ArrayList<>();
        loreList.add("This wand is made out of " + wandWood.toString());
        loreList.add("It's core is out of " + wandCore.toString());
        itemStack = new ItemStack(Material.STICK);
        itemStack.setLore(loreList);
        nbtItem = new NBTItem(itemStack);
        nbtItem.setBoolean(IS_WAND, true);
        nbtItem.setString(WAND_CORE_NBT, wandCore.name());
        nbtItem.setString(WAND_WOOD_NBT, wandWood.name());
    }

    public void bindSpell (Spell spell){
        boundSpell = spell;
        loreList.set(2, "Bound spell:" + boundSpell);
        itemStack.setLore(loreList);
    }

    public void give (Player player){
        player.getInventory().addItem(itemStack);
    }
}
