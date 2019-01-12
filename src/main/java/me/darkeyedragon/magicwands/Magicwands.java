package me.darkeyedragon.magicwands;

import co.aikar.commands.PaperCommandManager;
import me.darkeyedragon.magicwands.commands.CreateWandCommand;
import me.darkeyedragon.magicwands.commands.WandInfoCommand;
import me.darkeyedragon.magicwands.events.PlayerJoin;
import me.darkeyedragon.magicwands.events.WandRightClickEvent;
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

    public static final double BASE_DAMAGE = 5;
    public static Map<UUID, PlayerWithMana> manaMap = new HashMap<>();

    @Override
    public void onEnable (){
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new CreateWandCommand(this));
        commandManager.registerCommand(new WandInfoCommand(this));
        getServer().getPluginManager().registerEvents(new WandRightClickEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    @Override
    public void onDisable (){
        // Plugin shutdown logic
    }


}
