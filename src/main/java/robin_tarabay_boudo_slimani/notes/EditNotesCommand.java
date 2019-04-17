package robin_tarabay_boudo_slimani.notes;

/**
 * EditNotesCommand.java : Classe permettant d'éditer une note
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class EditNotesCommand implements Command {
	
	private App app;
	private String nom;
	
	/**
	 * Constructeur par défaut
	 * @param a qui prend en paramètre App
	 * @param n qui prend en paramètre un nom
	 */
	public EditNotesCommand(App a,String n)
	{
		this.app = a;
		this.nom = n;
	}


	/**
	 * Permet d'exécuter la commande d'édition
	 */
	public void execute()
	{
		app.edit(nom);
	}

}
