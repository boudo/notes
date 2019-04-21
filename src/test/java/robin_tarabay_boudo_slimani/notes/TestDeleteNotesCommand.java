package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDeleteNotesCommand {

	@Test
	public void TestInstanceDelete() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n ="jojo" ;
		DeleteNotesCommand d = new DeleteNotesCommand(gestionNotes,n);
		
		assertNotNull(d);
	}

}
