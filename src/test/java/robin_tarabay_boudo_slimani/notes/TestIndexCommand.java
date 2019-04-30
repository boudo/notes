package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIndexCommand {

	@Test
	public void TestInstanceIndex() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		IndexCommand i = new IndexCommand(gestionNotes);
		
		assertNotNull(i);
	}

}
