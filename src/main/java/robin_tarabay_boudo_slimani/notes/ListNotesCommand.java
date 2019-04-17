package robin_tarabay_boudo_slimani.notes;

/**
 * ListNotesCommand.java : Classe permettant de lister les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ListNotesCommand implements Command {
	
	private App app;
	
	/**
	 * Constructeur par défaut qui prend en argument App
	 * @param a qui prend en paramètre App
	 */
	public ListNotesCommand(App a)
	{
		this.app = a;
	}
	
	/**
	 * Permet d'exécuter la commande de liste
	 */
	public void execute() {
		app.liste();
		
	}

}
