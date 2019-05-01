package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.SearchNotesCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestSearchNotesCommand {

	@Test
	public void TestInstanceSearch() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n = "test" ;
		SearchNotesCommand sea = new SearchNotesCommand(gestionNotes,n);
		
		assertNotNull(sea);
	}

}
