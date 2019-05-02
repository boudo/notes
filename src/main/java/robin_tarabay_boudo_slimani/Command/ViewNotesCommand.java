package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
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
	
	public GestionNotes getGestionNotes() {
		return gestionNotes;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Permet d'exécuter la commande de view qui affiche une note
	 * @throws NoteOuMotCleManquantException une exception
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String execute() throws NoteOuMotCleManquantException,NotesOuMotClesInexistantException
	{
		if(nom.equals("") || nom.equals(" ") || nom == null)
		{
			throw new NoteOuMotCleManquantException("cette commande doit s'appliquer à une note\n");
		}
		
		return gestionNotes.view(nom);
	}
		
}
