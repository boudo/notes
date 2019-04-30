package robin_tarabay_boudo_slimani.notes;

public class IndexCommand implements Command {

private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut qui prend en argument GestionNotes
	 * @param g qui prend en paramètre GestionNotes
	 */
	public IndexCommand(GestionNotes g)
	{
		this.gestionNotes = g;
	}
	
	/**
	 * Permet d'exécuter la commande de configuration
	 * @return le fichier index.doc
	 */
	@Override
	public String execute()
	{
		
		return this.gestionNotes.index();
	}


}
