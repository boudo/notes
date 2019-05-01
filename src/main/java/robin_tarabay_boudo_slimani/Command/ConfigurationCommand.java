package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

/**
 * ConfigurationCommand.java : Classe permettant de modifier le fichier de configuration
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ConfigurationCommand implements Command {
	
	private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut qui prend en argument GestionNotes
	 * @param g qui prend en paramètre GestionNotes
	 */
	public ConfigurationCommand(GestionNotes g)
	{
		this.gestionNotes = g;
	}
	
	/**
	 * Permet d'exécuter la commande de configuration
	 * @return le fichier de configuration
	 */
	@Override
	public String execute()
	{	
		return this.gestionNotes.config();
	}

}
