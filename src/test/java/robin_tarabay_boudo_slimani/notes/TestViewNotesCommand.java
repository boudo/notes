package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestViewNotesCommand {

	@Test
	public void testConstructeur() {
		ViewNotesCommand cmd = new ViewNotesCommand("Test");
		assertNotNull(cmd);
	}
	
	@Test
	public void testGetNote() {
		ViewNotesCommand cmd = new ViewNotesCommand("Test");
		assertNotNull(cmd);
		assertTrue(cmd.getNote().equals("Test"));
	}


}
