package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSaisieCommand {

	@Test
	public void TestInstanceSaisie() {
		
		App app = new App();
		SaisieCommand s = new SaisieCommand(app);
		
		assertNotNull(s);
	}

}
