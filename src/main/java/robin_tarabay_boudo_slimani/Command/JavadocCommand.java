package robin_tarabay_boudo_slimani.Command;

import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

/**
 * JavadocCommand.java : Classe permettant d'accéder au manuel technique
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */
public class JavadocCommand implements Command {
	
	private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut qui prend en argument GestionNotes
	 * @param g qui prend en paramètre GestionNotes
	 */
	public JavadocCommand(GestionNotes g)
	{
		this.gestionNotes = g;
	}

	/**
	 * Permet d'exécuter la commande de javadoc
	 * @return l'exécution de la javadoc
	 */
	@Override
	public String execute()
	{
		return this.gestionNotes.javadoc();
	}

}
