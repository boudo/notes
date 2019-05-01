package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

/**
 * EditNotesCommand.java : Classe permettant d'éditer une note
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class EditNotesCommand implements Command {
	
	private GestionNotes gestionNotes;
	private String nom;
	private String context;
	private String projet;
	
	/**
	 * Constructeur par défaut
	 * @param g qui prend en paramètre GestionNotes
	 * @param n qui prend en paramètre un nom
	 * @param projet qui prend en paramètre un attribut projet
	 * @param context qui prend en paramètre un attribut context
	 */
	public EditNotesCommand(GestionNotes g,String n, String context, String projet)
	{
		this.gestionNotes = g;
		this.nom = n;
		this.context = context;
		this.projet = projet;
	}


	/**
	 * Permet d'exécuter la commande d'édition
	 * @return le nom de la note editée
	 * @throws NoteOuMotCleManquantException une exception
	 */
	public String execute() throws NoteOuMotCleManquantException
	{
		if(nom.equals("") || nom.equals(" ") || nom == null)
		{
			throw new NoteOuMotCleManquantException("cette commande doit s'appliquer à une note\n");
		}
		return gestionNotes.edit(nom, context, projet);
	}

}
