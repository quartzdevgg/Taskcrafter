package gg.quartzdev.mc.taskcrafter.storage.yml;

public enum ConfigPath
{

//    Red Team
    EXCHANGE_RED_A("exchange.red.a"),
    EXCHANGE_RED_B("exchange.red.a"),
    EXCHANGE_RED_C("exchange.red.a"),

    // Blue Team
    EXCHANGE_BLUE_A("exchange.blue.a"),
    EXCHANGE_BLUE_B("exchange.blue.b"),
    EXCHANGE_BLUE_C("exchange.blue.c"),

    // Yellow Team
    EXCHANGE_YELLOW_A("exchange.yellow.a"),
    EXCHANGE_YELLOW_B("exchange.yellow.b"),
    EXCHANGE_YELLOW_C("exchange.yellow.c"),

    // Green Team
    EXCHANGE_GREEN_A("exchange.green.a"),
    EXCHANGE_GREEN_B("exchange.green.b"),
    EXCHANGE_GREEN_C("exchange.green.c");
    private final String path;

    ConfigPath(String path)
    {
        this.path = path;
    }

    public String get()
    {
        return path;
    }
}