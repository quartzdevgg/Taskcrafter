package gg.quartzdev.mc.taskcrafter.storage.yml;


import gg.quartzdev.mc.taskcrafter.storage.ConfigOption;
import gg.quartzdev.mc.taskcrafter.storage.QConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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

        // Red Team
        setup(ConfigPath.EXCHANGE_RED_A, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_RED_A.get()));
        setup(ConfigPath.EXCHANGE_RED_B, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_RED_B.get()));
        setup(ConfigPath.EXCHANGE_RED_C, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_RED_C.get()));

        // Blue Team
        setup(ConfigPath.EXCHANGE_BLUE_A, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_BLUE_A.get()));
        setup(ConfigPath.EXCHANGE_BLUE_B, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_BLUE_B.get()));
        setup(ConfigPath.EXCHANGE_BLUE_C, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_BLUE_C.get()));

        // Yellow Team
        setup(ConfigPath.EXCHANGE_YELLOW_A, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_YELLOW_A.get()));
        setup(ConfigPath.EXCHANGE_YELLOW_B, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_YELLOW_B.get()));
        setup(ConfigPath.EXCHANGE_YELLOW_C, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_YELLOW_C.get()));

        // Green Team
        setup(ConfigPath.EXCHANGE_GREEN_A, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_GREEN_A.get()));
        setup(ConfigPath.EXCHANGE_GREEN_B, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_GREEN_B.get()));
        setup(ConfigPath.EXCHANGE_GREEN_C, new Location(Bukkit.getWorld("world"), 0, 0, 0), () -> yamlConfiguration.getBoolean(ConfigPath.EXCHANGE_GREEN_C.get()));

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