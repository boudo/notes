package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.ConfigurationCommand;
import robin_tarabay_boudo_slimani.notes.GestionNotes;

public class TestConfigurationCommand {

	@Test
	public void TestInstanceConf() {
		
		GestionNotes gestionNotes = new GestionNotes();
		
		ConfigurationCommand c = new ConfigurationCommand(gestionNotes);
		
		assertNotNull(c);
	}
}
