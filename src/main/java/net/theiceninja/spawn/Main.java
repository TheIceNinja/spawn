package net.theiceninja.spawn;

import net.theiceninja.spawn.commands.SetSpawnCommand;
import net.theiceninja.spawn.commands.SpawnCommand;
import net.theiceninja.spawn.listeners.JoinPlayerListener;
import net.theiceninja.spawn.listeners.RespawnListener;
import net.theiceninja.spawn.utils.ColorUtils;
import net.theiceninja.spawn.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &athe plugin is enabled!"));
        // commands
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        // listeners
        getServer().getPluginManager().registerEvents(new JoinPlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(this), this);


        // save the config and reload default
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ColorUtils.color(MessageUtils.PREFIX + " &cthe plugin is disabled!"));
    }
}
