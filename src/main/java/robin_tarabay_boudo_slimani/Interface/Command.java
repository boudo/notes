package robin_tarabay_boudo_slimani.Interface;

import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;

/**
 * Command.java : Interface Command
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public interface Command {
	/**
	 * Permet d'exécuter une commande
	 * @return un string
	 * @throws NoteOuMotCleManquantException une exception
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	String execute() throws NoteOuMotCleManquantException,NotesOuMotClesInexistantException;
}
