package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestGestionNotes {

//	@Before
//	public void initialize()
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//	}
	@Test(expected=Test.None.class)
	public void TestInstanceGestionNotes() throws IOException {
		
		GestionNotes gestionNotes = new GestionNotes();
		File fichier = new File("fc");
		String repTest="";
		String path;
		path = fichier.getCanonicalPath();
		path = path.substring(0, path.length() - 2);
		File rep = new File (path,"Document");
		repTest=rep.getCanonicalPath();
		assertEquals(gestionNotes.getRepertoire(),repTest);

	}
	
	@Test
	public void editNouveauTest(){
	GestionNotes gestionNotes = new GestionNotes();
	String tmpNote = "";
	gestionNotes.getNotes().put("test6",new Notes.NoteBuilder("test6").date(new Date(System.currentTimeMillis())).context("").project("").build());
	String editresult=gestionNotes.edit("test6");
	assertEquals(gestionNotes.getNotes().get("test6").getNom(),"test6");
	
	}
	
	@Test
	public void deleteFichierNonExistantTest()
	{
		GestionNotes gestionNotes = new GestionNotes();
		String del=gestionNotes.delete("FichierNonExistant.adoc");
		assertEquals(del,"Ce Fichier n'existe pas");
	}
	@Test
	public void deleteFichierExistantTest()
	{
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().put("trial1",new Notes.NoteBuilder("trial1").date(new Date(System.currentTimeMillis())).context("").project("").build());
		String del=gestionNotes.delete("trial1");
		assertEquals(del,"trial1 a été supprimer");
		assertFalse(gestionNotes.getNotes().containsKey("trial1"));
	}

}