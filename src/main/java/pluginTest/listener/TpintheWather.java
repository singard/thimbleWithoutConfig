package pluginTest.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pluginTest.commande.CommandeStartGame;

public class TpintheWather implements Listener{
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent eventPlayer) {
		
        Material material = eventPlayer.getTo().getBlock().getType();
        Player player = eventPlayer.getPlayer();
        final Location locationJump = new Location(Bukkit.getWorld("world"), -150,92,306);
        
        
        if (material.equals(Material.WATER) || material.equals(Material.STATIONARY_WATER)) {

        	final Location playerLocation = player.getLocation();
        	playerLocation.setY(playerLocation.getY()-1);
        	player.teleport(locationJump);
        	player.setFallDistance(0);
        	playerLocation.getBlock().setType(Material.WOOL);
         
            player.sendTitle("Bien joué V 15 !", "Attends ton tour.");
          
            CommandeStartGame.idJoueur++;
            CommandeStartGame.tpTopInJump();
          
            
            
        }
    }

}
