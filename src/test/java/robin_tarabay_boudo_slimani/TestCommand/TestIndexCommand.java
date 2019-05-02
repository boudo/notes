package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.IndexCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestIndexCommand {

	@Test
	public void TestInstanceIndex() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		IndexCommand i = new IndexCommand(gestionNotes);
		assertEquals(i.getGestionNotes(),gestionNotes);
		assertNotNull(i);
	}

}
