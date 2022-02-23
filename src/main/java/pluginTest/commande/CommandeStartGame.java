package pluginTest.commande;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import utils.commands.Command;
import utils.commands.CommandArgs;
import utils.commands.ICommand;

public class CommandeStartGame extends ICommand {

	@Override
	 @Command(name = "start")
	public void onCommand(CommandArgs args) {
		
		 	Player player = args.getPlayer();
		 	World world = player.getWorld();
		 	
	        PotionEffect PotionEffect  = new PotionEffect(PotionEffectType.WITHER,2000 , 2);
	        Location locationStart = new Location(world, 241,64,218);
	        player.teleport(locationStart);
	        player.addPotionEffect(PotionEffect);
	        Bukkit.getServer().getConsoleSender().sendMessage("la partie peut commencer");
	       // player.sendMessage("WITHER");
		
	}

}
