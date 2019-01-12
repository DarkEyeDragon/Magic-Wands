package me.darkeyedragon.magicwands.eventHandlers;

import me.darkeyedragon.magicwands.Magicwands;
import me.darkeyedragon.magicwands.database.DatabaseController;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;

public class PlayerJoinLeave implements Listener{

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event){
        try{
            DatabaseController.addPlayer(event.getPlayer());
            Magicwands.getManaMap().put(event.getPlayer().getUniqueId(), DatabaseController.getPlayerData(event.getPlayer()));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerQuit (PlayerQuitEvent event){
        try{
            DatabaseController.addPlayer(event.getPlayer());
            Magicwands.getManaMap().remove(event.getPlayer().getUniqueId(), DatabaseController.getPlayerData(event.getPlayer()));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}