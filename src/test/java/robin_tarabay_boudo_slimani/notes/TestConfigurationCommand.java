package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConfigurationCommand {

	@Test
	public void TestInstanceConf() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		ConfigurationCommand c = new ConfigurationCommand(gestionNotes);
		
		assertNotNull(c);
	}
}
