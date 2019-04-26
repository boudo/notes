package robin_tarabay_boudo_slimani.notes;

/**
 * DeleteNotesCommand.java : Classe permettant de supprimer une note
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class DeleteNotesCommand implements Command {

	
	private GestionNotes gestionNotes;
	private String nom;
	
	/**
	 * Constructeur par défaut
	 * @param g qui prend en paramètre GestionNotes
	 * @param n qui prend en paramètre un nom
	 */
	public DeleteNotesCommand(GestionNotes g,String n)
	{
		this.gestionNotes = g;
		this.nom = n;
	}
	
	/**
	 * Permet d'exécuter la commande de suppression
	 */
	public String execute() {
		
		return gestionNotes.delete(nom);
		
	}

}
