package me.darkeyedragon.magicwands;

import co.aikar.commands.PaperCommandManager;
import me.darkeyedragon.magicwands.commands.CreateWandCommand;
import me.darkeyedragon.magicwands.commands.WandInfoCommand;
import me.darkeyedragon.magicwands.eventHandlers.PlayerJoinLeave;
import me.darkeyedragon.magicwands.eventHandlers.SpellCastEventHandler;
import me.darkeyedragon.magicwands.eventHandlers.WandClickEventHandler;
import me.darkeyedragon.magicwands.spell.Spell;
import me.darkeyedragon.magicwands.wrappers.PlayerWithMana;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Magicwands extends JavaPlugin{

    public PaperCommandManager getCommandManager (){
        return commandManager;
    }

    private PaperCommandManager commandManager;

    private static Map<UUID, PlayerWithMana> manaMap = new HashMap<>();
    private static Map<String, Spell> spellMap = new HashMap<>();

    @Override
    public void onEnable (){
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new CreateWandCommand(this));
        commandManager.registerCommand(new WandInfoCommand(this));
        getServer().getPluginManager().registerEvents(new WandClickEventHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinLeave(), this);
        getServer().getPluginManager().registerEvents(new SpellCastEventHandler(), this);


        //Load the spells

        //TODO Implement spells
        //spellMap.put("", )
    }

    @Override
    public void onDisable (){
        // Plugin shutdown logic
    }

    public static Map<UUID, PlayerWithMana> getManaMap (){
        return manaMap;
    }

    public static Map<String, Spell> getSpellMap (){
        return spellMap;
    }
}
