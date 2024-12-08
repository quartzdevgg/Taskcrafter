package gg.quartzdev.mc.taskcrafter.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballHitListener implements Listener
{
    public SnowballHitListener()
    {

    }

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event)
    {
//        only care about snowballs thrown by players that hit players
        if(!(event.getEntity() instanceof Snowball snowball)) return;
        if(!(event.getHitEntity() instanceof Player player)) return;
        if(!(snowball.getShooter() instanceof Player)) return;



    }
}
