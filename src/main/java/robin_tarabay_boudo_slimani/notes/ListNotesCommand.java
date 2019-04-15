package robin_tarabay_boudo_slimani.notes;

/**
 * ListNotesCommand.java : Classe permettant de lister les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ListNotesCommand implements Command {
	
	/**
	 * Permet d'exécuter la commande de liste
	 */
	public void execute() {
		Notes.liste();
		
	}

}
