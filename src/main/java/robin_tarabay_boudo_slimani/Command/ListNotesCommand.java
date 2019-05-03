package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

/**
 * ListNotesCommand.java : Classe permettant de lister les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ListNotesCommand implements Command {
	
	private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut qui prend en argument GestionNotes
	 * @param g qui prend en paramètre GestionNotes
	 */
	public ListNotesCommand(GestionNotes g)
	{
		this.gestionNotes = g;
	}
	
	/**
	 * Permet de récupérer GestionNotes
	 * @return  qui renvoie la liste de notes
	 */
	public GestionNotes getGestionNotes() {
		return gestionNotes;
	}

	/**
	 * Permet d'exécuter la commande de liste
	 * @return le nom des notes présentes ou un message d'erreur
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String execute() throws NotesOuMotClesInexistantException {
		return gestionNotes.liste();
		
	}

}
