package robin_tarabay_boudo_slimani.Exception;

/**
 * CommandInexistantException.java : Classe permettant de lever une exception lorsque l'utilisateur essaye d'utiliser une commande qui n'existe pas. 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class CommandInexistantException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par Défaut
	 * @param message qui prend un message en argument
	 */
	public CommandInexistantException(String message) {
		super(message);
	}

}
