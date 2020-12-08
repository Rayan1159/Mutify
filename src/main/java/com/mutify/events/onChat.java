package com.mutify.events;

import files.muteFile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        muteFile.build(player.getName());
        boolean isMuted = muteFile.get().getBoolean("muted");

        System.out.println("muted:" + isMuted);

        if (isMuted) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[Mutify] " + ChatColor.BLUE + "You're muted.");
        }
    }

}
