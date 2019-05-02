package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.DeleteNotesCommand;
import robin_tarabay_boudo_slimani.Command.SearchNotesCommand;
import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestSearchNotesCommand {

	@Test
	public void TestInstanceSearch() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n = "test" ;
		SearchNotesCommand sea = new SearchNotesCommand(gestionNotes,n);
		assertEquals(sea.getMot(),n);
		assertEquals(sea.getGestionNotes(),gestionNotes);
		assertNotNull(sea);
	}
	@Test(expected=NoteOuMotCleManquantException.class)
	public void executeTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SearchNotesCommand d = new SearchNotesCommand(gestionNotes,"");
		d.execute();
	}
}
