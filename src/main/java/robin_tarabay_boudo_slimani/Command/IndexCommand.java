package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

/**
 * IndexCommand.java : Classe permettant de visualiser le fichier index.adoc
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class IndexCommand implements Command {

private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut qui prend en argument GestionNotes
	 * @param g qui prend en paramètre GestionNotes
	 */
	public IndexCommand(GestionNotes g)
	{
		this.gestionNotes = g;
	}
	
	/**
	 * Permet d'exécuter la commande de configuration
	 * @return le fichier index.doc
	 */
	@Override
	public String execute()
	{		
		return this.gestionNotes.index();
	}

	public GestionNotes getGestionNotes() {
		return gestionNotes;
	}


}
