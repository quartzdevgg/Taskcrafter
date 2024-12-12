package gg.quartzdev.mc.taskcrafter.storage.yml;


import gg.quartzdev.mc.lib.qlibpaper.storage.ConfigOption;
import gg.quartzdev.mc.lib.qlibpaper.storage.QConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Supplier;

public class YMLconfig extends QConfiguration
{

    public YMLconfig(JavaPlugin plugin, String fileName)
    {
        super(plugin, fileName, true);
        initializeAll();
        loadAllData();
    }

    @Override
    public void loadAllData()
    {
        configOptions.values().forEach(ConfigOption::load);
    }

    @Override
    public void saveAllData()
    {
    }

    public void initializeAll()
    {


    }

    public <T> void setup(ConfigPath path, T defaultValue, Supplier<T> loader)
    {
        configOptions.put(path.get(), new ConfigOption<>(path.get(), yamlConfiguration, loader));
    }

    @SuppressWarnings("unchecked")
    public <T> T get(ConfigPath key, T defaultValue)
    {
        try
        {
            ConfigOption<T> option = (ConfigOption<T>) configOptions.get(key.get());
            return option != null ? option.get() : defaultValue;
        } catch (ClassCastException ignored)
        {
            return defaultValue;
        }
    }

}