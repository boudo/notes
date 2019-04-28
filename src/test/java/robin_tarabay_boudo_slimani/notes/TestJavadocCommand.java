package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJavadocCommand {

	@Test
	public void TestInstanceJavadoc() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		JavadocCommand j = new JavadocCommand(gestionNotes);
		
		assertNotNull(j);
	}

}
