package robin_tarabay_boudo_slimani.TestCommand;

import static org.junit.Assert.*;

import org.junit.Test;

import robin_tarabay_boudo_slimani.Command.DeleteNotesCommand;
import robin_tarabay_boudo_slimani.Command.EditNotesCommand;
import robin_tarabay_boudo_slimani.Command.IndexCommand;
import robin_tarabay_boudo_slimani.Command.JavadocCommand;
import robin_tarabay_boudo_slimani.Command.ListNotesCommand;
import robin_tarabay_boudo_slimani.Command.SaisieCommand;
import robin_tarabay_boudo_slimani.Command.SearchNotesCommand;
import robin_tarabay_boudo_slimani.Command.ViewNotesCommand;
import robin_tarabay_boudo_slimani.Exception.CommandInexistantException;
import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;
import robin_tarabay_boudo_slimani.Exception.TropDargumentException;
import robin_tarabay_boudo_slimani.Interface.Command;
import robin_tarabay_boudo_slimani.notes.GestionNotes;
import robin_tarabay_boudo_slimani.notes.Notes;

import static org.junit.Assert.*;

import java.util.Date;
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
//	@Test
//	public void storeAndExecuteTest()
//	{
//
//		GestionNotes gestionNotes = new GestionNotes();
//		SaisieCommand s = new SaisieCommand(gestionNotes);
//		Command cmd1=new DeleteNotesCommand(gestionNotes,"testcmd1");
//		Command cmd2=new EditNotesCommand(gestionNotes,"testcmd2","projet","context");
//		
//		String st="";
//		try {
//			st = s.storeAndExecute("testcmd1 delete", cmd1);
//			assertEquals(st,"testcmd1 a été supprimer");
//		} catch (NoteOuMotCleManquantException | NotesOuMotClesInexistantException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			st=s.storeAndExecute("testcmd2 projet context edit", cmd2);
//		} catch (NoteOuMotCleManquantException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotesOuMotClesInexistantException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		assertEquals(st,"Edition de: testcmd2....");
//		
//		Map<String,Command> testmap=new HashMap();
//		testmap.put("testcmd1 delete", cmd1);
//		testmap.put("testcmd2 projet context edit", cmd2);
//		assertEquals(testmap,s.getCommands());
//	}

	@Test(expected =NotesOuMotClesInexistantException.class)
	public void executeListeAucuneNoteCommande() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException 
	{
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().clear();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new ListNotesCommand(gestionNotes);
		s.getCommands().put("ls", cmd1);
		String st=s.executeCommand("ls");
		assertEquals(st,"");
	}
	
//	@Test
//	public void executeEditTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//		SaisieCommand s = new SaisieCommand(gestionNotes);
//		Command cmd1=new EditNotesCommand(gestionNotes,"testcmd1","projet","context");
//		s.getCommands().put("testcmd1 edit", cmd1);
//		String st=s.executeCommand("testcmd1 edit");
//		assertEquals(st,"Edition de: testcmd1....");
//		
//	}
	@Test(expected =NoteOuMotCleManquantException.class)
	public void executeEditMotManquantTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{	
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new EditNotesCommand(gestionNotes,"","projet","context");
		s.getCommands().put(" projet", cmd1);
		s.executeCommand(" projet");

	}
	
	 @Test(expected =NotesOuMotClesInexistantException.class)
	public void executeViewTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new ViewNotesCommand(gestionNotes,"testviewcmd1");
		s.getCommands().put("testviewcmd1 view", cmd1);
		s.executeCommand("testviewcmd1 view");
		
	}
	 @Test(expected =NoteOuMotCleManquantException.class)
		public void executeViewMotManquantTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
		{
			GestionNotes gestionNotes = new GestionNotes();
			SaisieCommand s = new SaisieCommand(gestionNotes);
			Command cmd1=new ViewNotesCommand(gestionNotes,"");
			s.getCommands().put("view", cmd1);
			s.executeCommand("view");
			
		}
	@Test(expected =NotesOuMotClesInexistantException.class)
	public void executeDeleteTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new DeleteNotesCommand(gestionNotes,"testdeletecmd1");
		s.getCommands().put("testdeletecmd1 delete", cmd1);
		s.executeCommand("testdeletecmd1 delete");
	}
	
	@Test(expected =NoteOuMotCleManquantException.class)
	public void executeDeleteMotManquantTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new DeleteNotesCommand(gestionNotes,"");
		s.getCommands().put("delete", cmd1);
		s.executeCommand("delete");
	
	}

	@Test(expected =NotesOuMotClesInexistantException.class)
	public void executeSearchMotManquantTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
//		SaisieCommand s = new SaisieCommand(gestionNotes);
		Command cmd1=new SearchNotesCommand(gestionNotes,"GL");
//		s.getCommands().put("search", cmd1);
		cmd1.execute();
	}
	
//	//Celui ci est en commentaire car ca ouvre le javadoc
//	@Test
//	public void executeJavaDoc() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//		SaisieCommand s = new SaisieCommand(gestionNotes);
//		Command cmd1=new JavadocCommand(gestionNotes);
//		s.getCommands().put(" javadoc", cmd1);
//		String st=s.executeCommand(" javadoc");
//		assertEquals(st,"Lecture de la documentation java de l'application...\n");
//	}
//	//Celui ci /Celui ci est en commentaire car ca ouvre l'index
//	@Test
//	public void executeIndexCommand() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//		SaisieCommand s = new SaisieCommand(gestionNotes);
//		Command cmd1=new IndexCommand(gestionNotes);
//		s.getCommands().put("index", cmd1);
//		String st=s.executeCommand("index");
//		assertEquals(st,"Lecture de: " + "index" + "....");
//	}

}
