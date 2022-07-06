package net.theiceninja.spawn;

import net.theiceninja.spawn.commands.SetSpawnCommand;
import net.theiceninja.spawn.commands.SpawnCommand;
import net.theiceninja.spawn.listeners.JoinPlayerListener;
import net.theiceninja.spawn.listeners.RespawnListener;
import net.theiceninja.spawn.utils.ColorUtils;
import net.theiceninja.spawn.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ColorUtils.color(MessageUtils.PREFIX.getMessage() + " &athe plugin is enabled!"));
        // commands
        loadCommands();

        // listeners
        loadListeners(new JoinPlayerListener(this), new RespawnListener(this));

        // save the config and reload default
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    public void loadCommands(){
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
    }

    public void loadListeners(Listener... l){
        for (Listener listener : l) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ColorUtils.color(MessageUtils.PREFIX.getMessage() + " &cthe plugin is disabled!"));
    }
}
