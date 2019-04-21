package robin_tarabay_boudo_slimani.notes;

/**
 * EditNotesCommand.java : Classe permettant d'éditer une note
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class EditNotesCommand implements Command {
	
	private GestionNotes gestionNotes;
	private String nom;
	
	/**
	 * Constructeur par défaut
	 * @param a qui prend en paramètre App
	 * @param n qui prend en paramètre un nom
	 */
	public EditNotesCommand(GestionNotes a,String n)
	{
		this.gestionNotes = a;
		this.nom = n;
	}


	/**
	 * Permet d'exécuter la commande d'édition
	 */
	public void execute()
	{
		gestionNotes.edit(nom);
	}

}
