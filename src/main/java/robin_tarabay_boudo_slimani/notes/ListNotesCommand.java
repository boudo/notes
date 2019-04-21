package robin_tarabay_boudo_slimani.notes;

/**
 * ListNotesCommand.java : Classe permettant de lister les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ListNotesCommand implements Command {
	
	private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut qui prend en argument App
	 * @param a qui prend en paramètre App
	 */
	public ListNotesCommand(GestionNotes a)
	{
		this.gestionNotes = a;
	}
	
	/**
	 * Permet d'exécuter la commande de liste
	 */
	public void execute() {
		gestionNotes.liste();
		
	}

}
