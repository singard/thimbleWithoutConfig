
package pluginTest;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pluginTest.commande.CommandeStartGame;
import pluginTest.commande.CommandeYolo;
import pluginTest.listener.CreateListPlayer;
import pluginTest.listener.SheepListener;
import pluginTest.listener.TpintheWather;
import utils.commands.CommandFramework;

public class Main extends JavaPlugin {
	
	 private CommandFramework framework;
	 
	 private PluginManager pluginManager;
	 
	 public static List<Player> playerList = new LinkedList<Player>();

	    @Override
	    public void onEnable() {
	    	
	    	pluginManager = Bukkit.getServer().getPluginManager();
	    	pluginManager.registerEvents(new SheepListener(), this);
	    	pluginManager.registerEvents(new TpintheWather(), this);
	    	pluginManager.registerEvents(new CreateListPlayer(), this);

	        this.framework = new CommandFramework(this);

	        this.framework.registerCommands(new CommandeStartGame());
	        this.framework.registerCommands(new CommandeYolo());

	        Bukkit.getServer().getConsoleSender().sendMessage("Le plugin 18 s'est bien démarré !");
	    }

	    @Override
	    public void onDisable() {
	        Bukkit.getServer().getConsoleSender().sendMessage("Le plugin s'est bien arrêté !");
	    }

}
