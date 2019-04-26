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
	 * @param g qui prend en paramètre GestionNotes
	 * @param n qui prend en paramètre un nom
	 */
	public EditNotesCommand(GestionNotes g,String n)
	{
		this.gestionNotes = g;
		this.nom = n;
	}


	/**
	 * Permet d'exécuter la commande d'édition
	 */
	public String execute()
	{
		return gestionNotes.edit(nom);
	}

}
