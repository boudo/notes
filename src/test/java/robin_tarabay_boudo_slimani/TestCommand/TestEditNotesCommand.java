package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.DeleteNotesCommand;
import robin_tarabay_boudo_slimani.Command.EditNotesCommand;
import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestEditNotesCommand {

	@Test
	public void TestInstanceEdit() {
		
		GestionNotes gestionNotes = new GestionNotes();
		String n = "test" ;
		EditNotesCommand e = new EditNotesCommand(gestionNotes,n,"","");
		assertEquals(e.getGestionNotes(),gestionNotes);
		assertEquals(e.getNom(),n);
		assertEquals(e.getProjet(),"");
		assertEquals(e.getContext(),"");
		assertNotNull(e);
	}
	@Test(expected=NoteOuMotCleManquantException.class)
	public void executeTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		EditNotesCommand d = new EditNotesCommand(gestionNotes,"","","");
		d.execute();
	}

}
