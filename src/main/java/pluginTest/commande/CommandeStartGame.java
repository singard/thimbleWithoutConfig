package pluginTest.commande;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pluginTest.Main;
import utils.commands.Command;
import utils.commands.CommandArgs;
import utils.commands.ICommand;

public class CommandeStartGame extends ICommand {
public static int idJoueur = 0 ;

	@Override
	 @Command(name = "start")
	public void onCommand(CommandArgs args) {
		
		for (Player player : Main.playerList) {
			World world = player.getWorld();
			Location locationStart = new Location(world, -158,63,306);
	        player.teleport(locationStart);
	        Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
	        player.sendMessage("go !");
		}
		
		tpTopInJump();
		
	
	}
	
	public static void tpTopInJump() {
		if (idJoueur < Main.playerList.size()) {
			Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
			Player player = Main.playerList.get(idJoueur);
			World world = player.getWorld();
			Location locationStart = new Location(world, -150,84,307);
			player.teleport(locationStart);
		
		}else {
			Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
			idJoueur=0;
			tpTopInJump ();
		}
		
	}

}
