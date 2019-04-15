package robin_tarabay_boudo_slimani.notes;

/**
 * EditNotesCommand.java : Classe permettant d'éditer une note
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class EditNotesCommand implements Command {
	
	private String nom;
	
	
	public EditNotesCommand(String nom)
	{
		this.nom = nom;
	}


	/**
	 * Permet d'exécuter la commande d'édition
	 */
	public void execute()
	{
		System.out.println( "ok pour la command");
	}

}
