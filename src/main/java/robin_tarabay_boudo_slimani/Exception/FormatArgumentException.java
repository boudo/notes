package robin_tarabay_boudo_slimani.Exception;

/**
 * FormatArgumentException.java : Classe permettant de lever une exception lorsque l'utilisateur essaye d'utiliser un mauvais format. 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class FormatArgumentException extends Exception {
	
	// genre     e test -c -p cmd
	// genre     e test -c td -p
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par Défaut
	 * @param message qui prend un message en argument
	 */
	public FormatArgumentException(String message) {
		super(message);
	}
}
