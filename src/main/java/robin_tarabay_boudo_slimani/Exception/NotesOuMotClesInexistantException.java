package robin_tarabay_boudo_slimani.Exception;

/**
 * NotesInexistantException.java : Classe permettant de lever une exception lorsque l'utilisateur essaye d'utiliser une commande quand la note n'existe pas 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class NotesOuMotClesInexistantException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par Défaut
	 * @param message qui prend un message en argument
	 */
	public NotesOuMotClesInexistantException(String message) {
		super(message);
	}

}
