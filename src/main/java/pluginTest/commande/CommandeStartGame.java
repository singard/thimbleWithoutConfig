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
final public static  Location locationHub = new Location(Bukkit.getWorld("world"), -158,63,306);
final static public Location locationJump = new Location(Bukkit.getWorld("world"), -150,92,306);

	@Override
	 @Command(name = "start")
	public void onCommand(CommandArgs args) {
		
		for (Player player : Main.playerList) {
	        player.teleport(locationHub);
	        Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
	        player.sendMessage("go !");
		}
		
		tpTopInJump();
		
	
	}
	
	public static void tpTopInJump() {
		if (idJoueur < Main.playerList.size()) {
			Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
			Player player = Main.playerList.get(idJoueur);

			player.teleport(locationJump);
		
		}else {
			Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
			idJoueur=0;
			tpTopInJump ();
		}
		
	}

}
