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
	 * @param a qui prend en paramètre App
	 * @param n qui prend en paramètre un nom
	 */
	public DeleteNotesCommand(GestionNotes a,String n)
	{
		this.gestionNotes = a;
		this.nom = n;
	}
	
	/**
	 * Permet d'exécuter la commande de suppression
	 */
	public void execute() {
		
		gestionNotes.delete(nom);
		
	}

}
