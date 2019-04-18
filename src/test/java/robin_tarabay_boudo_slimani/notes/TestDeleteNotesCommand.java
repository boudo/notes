package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDeleteNotesCommand {

	@Test
	public void TestInstanceDelete() {
		
		App app = new App();
		String n ="jojo" ;
		DeleteNotesCommand d = new DeleteNotesCommand(app,n);
		
		assertNotNull(d);
	}

}
