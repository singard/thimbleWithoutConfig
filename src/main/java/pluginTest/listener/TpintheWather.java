package pluginTest.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pluginTest.commande.CommandeStartGame;

public class TpintheWather implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent eventPlayer) {
		Material material = eventPlayer.getTo().getBlock().getType();
		Player player = eventPlayer.getPlayer();

		Location from = eventPlayer.getFrom();
		Location to = eventPlayer.getTo();

		if (from.getX() != to.getX() || from.getY() != to.getY() || from.getZ() != to.getZ()) {
			if (material.equals(Material.WATER) || material.equals(Material.STATIONARY_WATER)) {

				final Location playerLocation = player.getLocation();
				playerLocation.setY(playerLocation.getY() - 1);
				player.teleport(CommandeStartGame.locationHub);
				player.setFallDistance(0);
				playerLocation.getBlock().setType(Material.WOOL);

				player.sendTitle("Bien joué V 17 !", "Attends ton tour.");

				CommandeStartGame.idJoueur++;
				CommandeStartGame.tpTopInJump();

			}
		}

	}

}
