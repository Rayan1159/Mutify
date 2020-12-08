package com.mutify;

import com.mutify.commands.mute;
import com.mutify.events.onChat;
import com.mutify.events.onJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;
import java.util.logging.Logger;

public final class main extends JavaPlugin {
    Logger logger = Bukkit.getLogger();
    File folder = new File(getDataFolder(), "/players/");

    @Override
    public void onEnable() {
        if (!(this.folder.exists())) {
            this.folder.mkdirs();
        }

        this.getServer().getPluginManager().registerEvents(new onChat(), this);
        this.getServer().getPluginManager().registerEvents(new onJoin(), this);

        Objects.requireNonNull(this.getCommand("mute")).setExecutor(new mute());

        this.logger.info(ChatColor.GREEN + "Loaded mutify");
    }

    @Override
    public void onDisable() {
        this.logger.info(ChatColor.RED + "Unloaded mutify");
    }
}
