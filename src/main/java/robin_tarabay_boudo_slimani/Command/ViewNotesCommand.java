package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Exception.NoteManquantException;
import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

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
	 * @throws NoteManquantException une exception
	 */
	public String execute() throws NoteManquantException
	{
		if(nom.equals("") || nom.equals(" ") || nom == null)
		{
			throw new NoteManquantException("cette commande doit s'appliquer à une note\n");
		}
		
		return gestionNotes.view(nom);
	}
		
}
