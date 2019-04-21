package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSaisieCommand {

	@Test
	public void TestInstanceSaisie() {
		
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		
		assertNotNull(s);
	}

}
