package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEditNotesCommand {

	@Test
	public void TestInstanceEdit() {
		
		App app = new App();
		String n = "test" ;
		EditNotesCommand e = new EditNotesCommand(app,n);
		
		assertNotNull(e);
	}

}
