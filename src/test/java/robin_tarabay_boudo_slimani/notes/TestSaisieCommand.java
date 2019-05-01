package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestSaisieCommand {

	
	@Test
	public void TestInstanceSaisie() {
		
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		assertEquals(s.getGestionNotes(),gestionNotes);
		assertTrue(s.getCommands().isEmpty());
	}
	@Test
	public void storeAndExecuteTest()
	{

		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new DeleteNotesCommand(gestionNotes,"testcmd1");
		Command cmd2=new EditNotesCommand(gestionNotes,"testcmd2");
		
		String st=s.storeAndExecute("testcmd1 delete", cmd1);
		assertEquals(st,"Ce Fichier n'existe pas");
		st=s.storeAndExecute("testcmd2 edit", cmd2);
		
		assertEquals(st,"Edition de: testcmd2....");
		
		Map<String,Command> testmap=new HashMap();
		testmap.put("testcmd1 delete", cmd1);
		testmap.put("testcmd2 edit", cmd2);
		assertEquals(testmap,s.getCommands());
	}

	
	@Test
	public void executeEditTest()
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new EditNotesCommand(gestionNotes,"testcmd1");
		s.getCommands().put("testcmd1 edit", cmd1);
		String st=s.executeCommand("testcmd1 edit");
		assertEquals(st,"Edition de: testcmd1....");
		
	}
	@Test
	public void executeViewTest()
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new ViewNotesCommand(gestionNotes,"testviewcmd1");
		s.getCommands().put("testviewcmd1 view", cmd1);
		String st=s.executeCommand("testviewcmd1 view");
		assertEquals(st,"Cette note n'existe pas");
	}
	@Test
	public void executeDeleteTest()
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new DeleteNotesCommand(gestionNotes,"testdeletecmd1");
		s.getCommands().put("testdeletecmd1 view", cmd1);
		String st=s.executeCommand("testdeletecmd1 view");
		assertEquals(st,"Ce Fichier n'existe pas");
	}
	
}
