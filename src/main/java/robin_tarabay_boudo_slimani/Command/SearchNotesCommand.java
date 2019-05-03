package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

/**
 * SearchNotesCommand.java : Classe permettant de rechercher des notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class SearchNotesCommand implements Command {

	private GestionNotes gestionNotes;
	private String mot;
	
	/**
	 * Constructeur par défaut 
	 * @param g qui prend en paramètre GestionNotes
	 * @param n qui prend en paramètre String
	 */
	public SearchNotesCommand(GestionNotes g,String n) {
		this.gestionNotes = g;
		this.mot = n;
	}
	
	/**
	 * Permet de récupérer GestionNotes
	 * @return  qui renvoie la liste de notes
	 */
	public GestionNotes getGestionNotes() {
		return gestionNotes;
	}

	/**
	 * Permet de récupérer un mot
	 * @return  qui renvoie le mot
	 */
	public String getMot() {
		return mot;
	}

	/**
	 * Permet d'exécuter la commande de recherche
	 * @return la liste des fichiers contenant le mot-clé ou la phrase demandée
	 * @throws NoteOuMotCleManquantException une exception
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String execute() throws NoteOuMotCleManquantException,NotesOuMotClesInexistantException
	{
		if(mot.equals("") || mot.equals(" ") || mot == null)
		{
			throw new NoteOuMotCleManquantException("cette commande doit s'appliquer à un mot-clé,une phrase ou plusieurs mots.\n");
		}
		
		return gestionNotes.search(mot);
	}

}
