package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.ViewNotesCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestViewNotesCommand {

	@Test
	public void testConstructeur() {
		
		GestionNotes gestionNotes = new GestionNotes();
		ViewNotesCommand cmd = new ViewNotesCommand(gestionNotes,"Test");
		assertNotNull(cmd);
	}

}
