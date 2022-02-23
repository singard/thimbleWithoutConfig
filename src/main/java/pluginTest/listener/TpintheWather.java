package pluginTest.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
        Block bloc = eventPlayer.getTo().getBlock();
        
        if (material.equals(Material.WATER) || material.equals(Material.STATIONARY_WATER)) {
            bloc.setType(Material.WOOL);
            Player player = eventPlayer.getPlayer();
            player.teleport(new Location(Bukkit.getWorld("world"), -158,63,306));
            player.sendTitle("Bien joué :p !", "Attends ton tour.");
            CommandeStartGame.idJoueur++;
            CommandeStartGame.tpTopInJump();
            
            
        }
    }

}
