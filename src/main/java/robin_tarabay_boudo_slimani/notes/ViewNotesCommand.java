package robin_tarabay_boudo_slimani.notes;


/**
 * ViewNotesCommand.java : Classe permettant de visualiser les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ViewNotesCommand implements Command {
	
	private GestionNotes gestionNotes;
	private String nom;
	
	/**
	 * Constructeur ViewNotesCommand
	 * @param g qui prend en paramètre GestionNotes
	 * @param n qui prend en paramètre un nom
	 */
	public ViewNotesCommand(GestionNotes g,String n)
	{
		this.gestionNotes = g;
		this.nom = n;
	}
	
	/**
	 * Permet d'exécuter la commande de view qui affiche une note
	 */
	public String execute()
	{
		return gestionNotes.view(nom);
	}
		
}
