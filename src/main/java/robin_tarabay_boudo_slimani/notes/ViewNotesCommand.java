package robin_tarabay_boudo_slimani.notes;



/**
 * ViewNotesCommand.java : Classe permettant de visualiser les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ViewNotesCommand implements Command {
	
	private App app;
	private String nom;
	
	/**
	 * Constructeur ViewNotesCommand
	 * @param a qui prend en paramètre App
	 * @param n qui prend en paramètre un nom
	 */
	public ViewNotesCommand(App a,String n)
	{
		this.app = a;
		this.nom = n;
	}
	
	/**
	 * Permet d'exécuter la commande de view qui affiche une note
	 */
	public void execute()
	{
		app.view(nom);
	}
		
}
