package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestViewNotesCommand {

	@Test
	public void testConstructeur() {
		
		App app = new App();
		ViewNotesCommand cmd = new ViewNotesCommand(app,"Test");
		assertNotNull(cmd);
	}

}
