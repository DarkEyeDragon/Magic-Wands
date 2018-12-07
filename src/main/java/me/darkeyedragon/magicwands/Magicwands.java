package me.darkeyedragon.magicwands;

import co.aikar.commands.PaperCommandManager;
import me.darkeyedragon.magicwands.commands.CreateWandCommand;
import me.darkeyedragon.magicwands.commands.WandInfoCommand;
import me.darkeyedragon.magicwands.events.WandRightClickEvent;
import me.darkeyedragon.magicwands.spells.Spell;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Magicwands extends JavaPlugin{

    private PaperCommandManager manager;

    public static final double BASE_DAMAGE = 5;
    public static Map<Player, Spell> recentlyCast;

    @Override
    public void onEnable (){
        // Plugin startup logic
        recentlyCast = new HashMap<>();
        manager = new PaperCommandManager(this);
        manager.registerCommand(new CreateWandCommand(this));
        manager.registerCommand(new WandInfoCommand(this));
        getServer().getPluginManager().registerEvents(new WandRightClickEvent(), this);

    }

    @Override
    public void onDisable (){
        // Plugin shutdown logic
    }
}
