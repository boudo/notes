package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestViewNotesCommand {

	@Test
	public void testConstructeur() {
		
		GestionNotes gestionNotes = new GestionNotes();
		ViewNotesCommand cmd = new ViewNotesCommand(gestionNotes,"Test");
		assertNotNull(cmd);
	}

}
