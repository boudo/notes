package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.DeleteNotesCommand;
import robin_tarabay_boudo_slimani.Command.EditNotesCommand;
import robin_tarabay_boudo_slimani.Command.SaisieCommand;
import robin_tarabay_boudo_slimani.Command.ViewNotesCommand;
import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;



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
		Command cmd2=new EditNotesCommand(gestionNotes,"testcmd2","projet","context");
		
		String st="";
		try {
			st = s.storeAndExecute("testcmd1 delete", cmd1);
			assertEquals(st,"Ce Fichier n'existe pas");
		} catch (NoteOuMotCleManquantException | NotesOuMotClesInexistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st=s.storeAndExecute("testcmd2 projet context edit", cmd2);
		} catch (NoteOuMotCleManquantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotesOuMotClesInexistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(st,"Edition de: testcmd2....");
		
		Map<String,Command> testmap=new HashMap();
		testmap.put("testcmd1 delete", cmd1);
		testmap.put("testcmd2 projet context edit", cmd2);
		assertEquals(testmap,s.getCommands());
	}

	
	@Test
	public void executeEditTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new EditNotesCommand(gestionNotes,"testcmd1","projet","context");
		s.getCommands().put("testcmd1 projet", cmd1);
		String st=s.executeCommand("testcmd1 projet");
		assertEquals(st,"Edition de: testcmd1....");
		
	}
	 @Test(expected =NotesOuMotClesInexistantException.class)
	public void executeViewTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new ViewNotesCommand(gestionNotes,"testviewcmd1");
		s.getCommands().put("testviewcmd1 view", cmd1);
		String st=s.executeCommand("testviewcmd1 view");
		assertEquals(st,"Cette note n'existe pas!");
	}
	@Test(expected =NotesOuMotClesInexistantException.class)
	public void executeDeleteTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new DeleteNotesCommand(gestionNotes,"testdeletecmd1");
		s.getCommands().put("testdeletecmd1 delete", cmd1);
		String st=s.executeCommand("testdeletecmd1 delete");
		assertEquals(st,"");
	}
//	@Test 
//	public void SaisieCommandOneArg()
//	{
//
//		GestionNotes gestionNotes = new GestionNotes();
//		SaisieCommand s = new SaisieCommand(gestionNotes);
//		String[] args=new String[10];
//		args[0]="edit";
//		
//	}
}
