package com.mutify.events;

import files.muteFile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String player = e.getPlayer().getName();
        muteFile.build(player);
        muteFile.config.options().copyDefaults(true);
        muteFile.config.addDefault("muted", false);
        muteFile.save();
    }

}
