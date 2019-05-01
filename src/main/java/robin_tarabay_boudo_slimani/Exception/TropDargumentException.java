package robin_tarabay_boudo_slimani.Exception;

/**
 * TropDargumentException.java : Classe permettant de lever une exception lorsque l'utilisateur essaye d'utiliser trop d'arguments 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class TropDargumentException extends Exception {
	
	// genre     e test -c td -p cmd -d rigolo
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par Défaut
	 * @param message qui prend un message en argument
	 */
	public TropDargumentException(String message) {
		super(message);
	}
}
