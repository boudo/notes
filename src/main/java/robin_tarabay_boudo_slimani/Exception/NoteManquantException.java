package robin_tarabay_boudo_slimani.Exception;

/**
 * NoteManquantException.java : Classe permettant de lever une exception lorsque l'utilisateur essaye d'utiliser une commande qui nécessite un nom de note.
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */
public class NoteManquantException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par Défaut
	 * @param message qui prend un message en argument
	 */
	public NoteManquantException(String message) {
		super(message);
	}
}
