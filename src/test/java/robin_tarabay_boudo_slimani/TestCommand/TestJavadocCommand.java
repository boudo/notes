package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.JavadocCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestJavadocCommand {

	@Test
	public void TestInstanceJavadoc() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		JavadocCommand j = new JavadocCommand(gestionNotes);
		assertEquals(j.getGestionNotes(),gestionNotes);
		assertNotNull(j);
	}

}
