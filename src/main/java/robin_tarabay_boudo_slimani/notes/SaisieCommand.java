package robin_tarabay_boudo_slimani.notes;

/**
 * SaisieNotes.java : Classe permettant de saisir des notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */


public class SaisieCommand {
	
	/**
	 * Constructeur par défaut
	 */
	public SaisieCommand() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Permet de stocker et d'exécuter la commande
	 * @param cmd qui permet de passer une cmd en paramètre
	 */
	public void storeAndExecute(Command cmd) { 
	      cmd.execute();        
	}
}
