package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSearchNotesCommand {

	@Test
	public void TestInstanceSearch() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n = "test" ;
		SearchNotesCommand sea = new SearchNotesCommand(gestionNotes,n);
		
		assertNotNull(sea);
	}

}
