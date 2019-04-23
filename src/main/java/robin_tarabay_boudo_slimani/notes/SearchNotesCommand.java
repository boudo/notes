package robin_tarabay_boudo_slimani.notes;

/**
 * SearchNotesCommand.java : Classe permettant de rechercher des notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class SearchNotesCommand implements Command {

	private GestionNotes gestionNotes;
	private String mot;
	
	
	public SearchNotesCommand(GestionNotes a,String n) {
		this.gestionNotes = a;
		this.mot = n;
	}
	public void execute() {
		gestionNotes.search(mot);
	}

}
