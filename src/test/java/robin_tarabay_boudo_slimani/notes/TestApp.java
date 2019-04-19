package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestApp {

	@Test
	public void TestInstanceApp() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		assertNotNull(gestionNotes);
	}

}
