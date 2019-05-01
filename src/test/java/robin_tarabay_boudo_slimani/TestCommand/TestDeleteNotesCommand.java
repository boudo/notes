package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.DeleteNotesCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestDeleteNotesCommand {

	@Test
	public void TestInstanceDelete() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n ="jojo" ;
		DeleteNotesCommand d = new DeleteNotesCommand(gestionNotes,n);
		
		assertNotNull(d);
	}

}
