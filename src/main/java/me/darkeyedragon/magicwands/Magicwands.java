package me.darkeyedragon.magicwands;

import co.aikar.commands.PaperCommandManager;
import me.darkeyedragon.magicwands.commands.CreateWandCommand;
import me.darkeyedragon.magicwands.events.WandRightClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Magicwands extends JavaPlugin{

    PaperCommandManager manager;


    @Override
    public void onEnable (){
        // Plugin startup logic
        manager = new PaperCommandManager(this);
        manager.registerCommand(new CreateWandCommand());
        getServer().getPluginManager().registerEvents(new WandRightClickEvent(), this);

    }

    @Override
    public void onDisable (){
        // Plugin shutdown logic
    }
}
