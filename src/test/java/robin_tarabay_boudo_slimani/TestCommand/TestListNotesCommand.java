package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.ListNotesCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestListNotesCommand {

	@Test
	public void TestInstanceList() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		ListNotesCommand l = new ListNotesCommand(gestionNotes);
		assertEquals(l.getGestionNotes(),gestionNotes);
		assertNotNull(l);
	}

}
