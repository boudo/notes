package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.EditNotesCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestEditNotesCommand {

	@Test
	public void TestInstanceEdit() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n = "test" ;
		EditNotesCommand e = new EditNotesCommand(gestionNotes,n, null, null);
		
		assertNotNull(e);
	}

}
