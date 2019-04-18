package robin_tarabay_boudo_slimani.notes;

/**
 * DeleteNotesCommand.java : Classe permettant de supprimer une note
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class DeleteNotesCommand implements Command {

	
	private App app;
	private String nom;
	
	/**
	 * Constructeur par défaut
	 * @param a qui prend en paramètre App
	 * @param n qui prend en paramètre un nom
	 */
	public DeleteNotesCommand(App a,String n)
	{
		this.app = a;
		this.nom = n;
	}
	
	/**
	 * Permet d'exécuter la commande de suppression
	 */
	public void execute() {
		
		app.delete(nom);
		
	}

}
