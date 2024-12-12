package gg.quartzdev.mc.taskcrafter;

import gg.quartzdev.mc.lib.qlibpaper.QLogger;
import gg.quartzdev.mc.lib.qlibpaper.QPluginAPI;
import gg.quartzdev.mc.lib.qlibpaper.commands.CommandManager;
import gg.quartzdev.mc.lib.qlibpaper.lang.GenericMessages;
import gg.quartzdev.mc.taskcrafter.commands.CMDtaskcrafter;
import gg.quartzdev.mc.taskcrafter.commands.CMDtasklist;
import gg.quartzdev.mc.taskcrafter.commands.CMDteams;
import gg.quartzdev.mc.taskcrafter.listeners.InventoryListener;
import gg.quartzdev.mc.taskcrafter.listeners.SnowballHitListener;
import gg.quartzdev.mc.taskcrafter.util.Messages;
import gg.quartzdev.mc.taskcrafter.storage.yml.YMLconfig;
import gg.quartzdev.metrics.bukkit.Metrics;
import org.bukkit.Bukkit;

import java.util.List;

public class TaskcrafterAPI implements QPluginAPI
{

    private static TaskcrafterAPI apiInstance;
    private static Taskcrafter pluginInstance;
    private static Messages messages;
    private static CommandManager commandManager;
    private static gg.quartzdev.metrics.bukkit.Metrics metrics;
    private static YMLconfig config;
    private final String CONSOLE_PREFIX = "<white>[<color:#ffc629>Taskcrafter<white>]";
    private final String CHAT_PREFIX = "<color:#ffc629>Taskcrafter <bold><gray>>></bold>";
    private final String MODRINTH_SLUG = "taskcrafter".toLowerCase();
    private final String MODRINTH_LOADER = "paper";

    private TaskcrafterAPI()
{
}

    private TaskcrafterAPI(Taskcrafter plugin, int bStatsPluginId)
    {

//        Used to get plugin instance in other classes
        pluginInstance = plugin;

//        Initializes custom logger
        QLogger.init(pluginInstance.getComponentLogger());

//        Loads custom messages defined in messages.yml
        setupMessages();

//        Sets up bStats metrics
        if (bStatsPluginId > 0)
        {
            setupMetrics(bStatsPluginId);
        }

//        Sets up config.yml
        setupConfig();

//        Initializes bukkit event listeners
        registerListeners();

//        Registers all commands
        registerCommands();
    }

    public static Taskcrafter getPlugin()
    {
        return pluginInstance;
    }

    public static YMLconfig getConfig()
    {
        return config;
    }

    @SuppressWarnings("SameParameterValue")
    protected static void enable(Taskcrafter plugin, int bStatsPluginId)
    {
        if (apiInstance != null)
        {
            QLogger.error(GenericMessages.ERROR_PLUGIN_ENABLE);
            return;
        }
        apiInstance = new TaskcrafterAPI(plugin, bStatsPluginId);

    }

    protected static void disable()
    {

//        Logs plugin is being disabled
        QLogger.info(GenericMessages.PLUGIN_DISABLE);

//        Clears instances
        apiInstance = null;
        pluginInstance = null;
        config = null;
        if (metrics != null)
        {
            metrics.shutdown();
            metrics = null;
        }
    }

    @SuppressWarnings("UnstableApiUsage")
    public static String getVersion()
    {
        return pluginInstance.getPluginMeta().getVersion();
    }

    public static String getName()
    {
        return pluginInstance.getName();
    }

    public static void loadCustomMessages()
    {
        messages.reload();
    }

    public void setupMetrics(int pluginId)
    {
        metrics = new Metrics(pluginInstance, pluginId);
    }

    public void registerCommands()
    {
        commandManager = new CommandManager(pluginInstance);
        commandManager.add(new CMDtaskcrafter(), null);
        commandManager.add(new CMDteams(), List.of("team", "party"));
        commandManager.add(new CMDtasklist(), List.of("tasks", "list", "collects", "items", "collectionlist"));
        commandManager.registerCommands();
    }

    public void registerListeners()
    {
        Bukkit.getPluginManager().registerEvents(new SnowballHitListener(), pluginInstance);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), pluginInstance);
    }

    public void setupConfig()
    {
        config = new YMLconfig(pluginInstance, "config.yml");
    }

    public void setupMessages()
    {
        messages = new Messages(CONSOLE_PREFIX, CHAT_PREFIX);
    }

    public void setupUpdater(String slug, String loader)
    {
//        Bukkit.getPluginManager().registerEvents(new UpdateCheckerListener(slug, loader), pluginInstance);
    }
}
