package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEditNotesCommand {

	@Test
	public void TestInstanceEdit() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n = "test" ;
		EditNotesCommand e = new EditNotesCommand(gestionNotes,n);
		
		assertNotNull(e);
	}

}
