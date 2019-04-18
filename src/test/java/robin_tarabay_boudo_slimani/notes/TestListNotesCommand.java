package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestListNotesCommand {

	@Test
	public void TestInstanceList() {
		
		App app = new App();
		
		ListNotesCommand l = new ListNotesCommand(app);
		
		assertNotNull(l);
	}

}
