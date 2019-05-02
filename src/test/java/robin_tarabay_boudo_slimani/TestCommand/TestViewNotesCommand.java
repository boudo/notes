package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.SearchNotesCommand;
import robin_tarabay_boudo_slimani.Command.ViewNotesCommand;
import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestViewNotesCommand {

	@Test
	public void testConstructeur() {
		
		GestionNotes gestionNotes = new GestionNotes();
		ViewNotesCommand cmd = new ViewNotesCommand(gestionNotes,"Test");
		assertEquals(cmd.getGestionNotes(),gestionNotes);
		assertEquals(cmd.getNom(),"Test");
		assertNotNull(cmd);
	}
	@Test(expected=NoteOuMotCleManquantException.class)
	public void executeTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		ViewNotesCommand d = new ViewNotesCommand(gestionNotes,"");
		d.execute();
	}
}
