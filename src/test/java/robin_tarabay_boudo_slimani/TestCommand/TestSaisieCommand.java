package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.SaisieCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestSaisieCommand {

	@Test
	public void TestInstanceSaisie() {
		
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		
		assertNotNull(s);
	}

}
