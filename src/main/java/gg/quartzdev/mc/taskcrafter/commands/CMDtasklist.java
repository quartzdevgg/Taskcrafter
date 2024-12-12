package gg.quartzdev.mc.taskcrafter.commands;

import gg.quartzdev.mc.lib.qlibpaper.commands.QCMD;
import gg.quartzdev.mc.taskcrafter.TaskcrafterAPI;
import gg.quartzdev.mc.taskcrafter.gui.ExchangeInventory;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CMDtasklist extends QCMD
{
    NamespacedKey colorKey = new NamespacedKey(TaskcrafterAPI.getPlugin(), "exchange_color");
    NamespacedKey tierKey = new NamespacedKey(TaskcrafterAPI.getPlugin(), "exchange_tier");

    public CMDtasklist()
    {
        super(
                "tasklist",
                "View the tasklist for Taskcrafter",
                "taskcrafter.command.tasklist",
                "taskcrafter.player",
                true
        );
    }

    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
    {
        if(!(commandSourceStack.getExecutor() instanceof Player player)) return;
        new ExchangeInventory(player);
    }

    @Override
    public @NotNull List<String> tabCompletionLogic(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
    {
        return new ArrayList<>();
    }
}
