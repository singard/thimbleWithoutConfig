package pluginTest.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pluginTest.Main;

public class CreateListPlayer implements Listener{
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("Welcome, " + event.getPlayer().getName() + "!");
        
       Main.playerList.add(event.getPlayer());
       event.setJoinMessage("le joueur, " + event.getPlayer().getName() + " a bien �t� ajout� � la liste");
       event.setJoinMessage("joueur pr�sent :");
       for (Player player : Main.playerList) {
    	   
    	   event.setJoinMessage(player.getName()); 
       }
    }
	
	
}
