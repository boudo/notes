package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.DeleteNotesCommand;
import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestDeleteNotesCommand {

	@Test
	public void TestInstanceDelete() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n ="test" ;
		DeleteNotesCommand d = new DeleteNotesCommand(gestionNotes,n);
		assertEquals(d.getGestionNotes(),gestionNotes);
		assertNotNull(d);
	}
	@Test(expected=NoteOuMotCleManquantException.class)
	public void executeTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		DeleteNotesCommand d = new DeleteNotesCommand(gestionNotes,"");
		d.execute();
	}

}
