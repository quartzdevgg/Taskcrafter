package gg.quartzdev.mc.taskcrafter.commands.team;


import gg.quartzdev.mc.taskcrafter.util.QCMD;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CMDteams extends QCMD
{
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
        switch (args.length)
        {
        }
    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
    {
        return switch(args.length)
        {
            case 0 -> List.of("zero", "args", "found");
            case 1 -> List.of("1", "arg");
            case 2 -> List.of("TWO ARGS");
            default -> List.of();
        };
    }
}

