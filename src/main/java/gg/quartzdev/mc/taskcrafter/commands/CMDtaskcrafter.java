package gg.quartzdev.mc.taskcrafter.commands;


import gg.quartzdev.mc.lib.qlibpaper.commands.QCMD;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CMDtaskcrafter extends QCMD
{
    /**
     * Constructor for creating a new command
     * You must call super() and pass in the following parameters resepctively in super():<br>
     * <ul>
     *     <li>label: the label of the command</li>
     *     <li>description: the description of the command</li>
     *     <li>permission: the permission node required to use the command</li>
     *     <li>permissionPackage: an alternate permission node required to use the command, typically many commands will share a permission "package" node</li>
     *     <li>requiresPermission: whether the player needs to have the permission to use the command, a player with the permission set to false will still not be able to use the command</li>
     * </ul>
     */
    public CMDtaskcrafter(){
        super(
                "taskcrafter",
                "Basic command for Taskcrafter",
                "taskcrafter.command",
                "taskcrafter.player",
                true
        );
    }

    /**
     * This method is called when the command is executed by a player
     * Note: this method works for any {@link CommandSourceStack}, not just a player
     * @param commandSourceStack the commandSourceStack of the command
     * @param args the arguments passed in by the commandSourceStack
     */
    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
    {
        switch (args.length)
        {
            case 0 -> commandSourceStack.getSender().sendRichMessage("<red>no args");
            case 1 -> commandSourceStack.getSender().sendRichMessage("<blue>1 args");
            case 2 -> commandSourceStack.getSender().sendRichMessage("<green>2 args");
            default -> commandSourceStack.getSender().sendRichMessage("<green>everything else args");
        }
    }

    /**
     * This method is called as a player types in a command and can be used to suggest a parameters to the player
     * Note: this method works for any {@link CommandSourceStack}, not just a player
     * @param commandSourceStack the commandSourceStack of the command
     * @param args the arguments of the command including repeated spaces
     * @return a list of suggestions for the player
     */
    @Override
    public @NotNull List<String> tabCompletionLogic(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args)
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
