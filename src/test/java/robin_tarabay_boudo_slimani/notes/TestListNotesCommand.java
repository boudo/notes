package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestListNotesCommand {

	@Test
	public void TestInstanceList() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		ListNotesCommand l = new ListNotesCommand(gestionNotes);
		
		assertNotNull(l);
	}

}
