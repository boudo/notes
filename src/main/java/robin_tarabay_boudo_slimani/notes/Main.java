package robin_tarabay_boudo_slimani.notes;

import robin_tarabay_boudo_slimani.Command.SaisieCommand;

/**
 * Main.java : Classe principale du Programme
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class Main {
	/**
	 * Fonction principale du programme 
	 * @param args pour récupérer les commandes saisies par l'utilisateur
	 */
	public static void main( String[] args )
    {
    	GestionNotes gestionNotes = new GestionNotes();
    	SaisieCommand saisie = new SaisieCommand(gestionNotes);
    	saisie.saisieUser(args);
    }

}
