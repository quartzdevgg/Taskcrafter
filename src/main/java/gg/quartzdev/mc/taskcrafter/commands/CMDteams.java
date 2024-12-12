package gg.quartzdev.mc.taskcrafter.commands;


import gg.quartzdev.mc.lib.qlibpaper.Sender;
import gg.quartzdev.mc.lib.qlibpaper.commands.QCMD;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CMDteams extends QCMD
{

    List<String> colors = List.of(
            "red", "blue", "yellow", "green"
    );

    public CMDteams(){
        super(
                "teams",
                "Teams command for Taskcrafter",
                "taskcrafter.command.teams",
                "taskcrafter.mod",
                true
        );
    }

    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
    {
        CommandSender sender = commandSourceStack.getSender();
        switch (args.length)
        {
            case 0 -> Sender.message(sender,"<prefix> <red>/teams assign <player> <team>");
            default -> {
                switch (args[0])
                {
                    case "assign" -> Sender.message(commandSourceStack.getSender(), "<prefix> <red>Not implemented");
                    default -> {
                        Sender.message(commandSourceStack.getSender(), "<prefix> <red>Unknown command: " + args[0]);
                    }
                }
            }
        }
    }

    @Override
    public @NotNull List<String> tabCompletionLogic(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
    {
        List<String> rawCompletions = switch(args.length)
        {
            case 0, 1 -> List.of("assign", "list", "info", "points");
            case 2 -> switch(args[0])
            {
                case "assign" -> Bukkit.getOnlinePlayers().stream().map(Player::getName).toList();
                default -> List.of();
            };
            case 3 -> switch(args[0])
            {
                case "assign" -> colors;
                default -> List.of();
            };
            default -> List.of();
        };
        return new ArrayList<>(rawCompletions);
    }
}

