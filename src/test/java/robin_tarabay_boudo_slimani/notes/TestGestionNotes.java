package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;

public class TestGestionNotes {

//	@Before
//	public void initialize()
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//	}

	@Test
	public void TestInstanceGestionNotes() throws IOException, FileNotFoundException {

		GestionNotes gestionNotes = new GestionNotes();
		FileInputStream fs = new FileInputStream(new File(".configuration"));
		Scanner scanner = new Scanner(fs);

		String index = "";
		String rep = "";
		String repRacin = "";
		String editeur = "";
		String navig = "";
		while (scanner.hasNext()) {
			index = scanner.next();
			if (index.equals("RACINE:")) {
				repRacin = scanner.next();
				gestionNotes.setRepRacine(repRacin);
			} else if (index.equals("REPERTOIRE:")) {
				rep = scanner.next();
				gestionNotes.setRepertoire(rep);
			} else if (index.equals("EDITEUR:")) {
				editeur = scanner.next();
				gestionNotes.setEditeur(editeur);
			} else if (index.equals("NAVIGATEUR:")) {
				navig = scanner.next();
				gestionNotes.setNavigateur(navig);
			}
		}

		assertEquals(gestionNotes.getRepertoire(), rep);
		assertEquals(gestionNotes.getRepRacine(), repRacin);
		assertEquals(gestionNotes.getEditeur(), editeur);
		assertEquals(gestionNotes.getNavigateur(), navig);
		gestionNotes.getNotes().clear();
	}

	@Test
	public void listeTest() throws NotesOuMotClesInexistantException {
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().clear();
		gestionNotes.getNotes().put("trial1", new Notes.NoteBuilder("trial1").date(new Date(System.currentTimeMillis()))
				.context("").project("").build());
		gestionNotes.getNotes().put("trial2", new Notes.NoteBuilder("trial2").date(new Date(System.currentTimeMillis()))
				.context("").project("").build());
		String st = gestionNotes.liste();
		assertEquals(st,
				"--------------------------------------------------------------------------------\n"
						+ "Voici la liste de vos notes:\n" + "\n" + "+ trial1\n" + "+ trial2\n"
						+ "--------------------------------------------------------------------------------");
		gestionNotes.getNotes().clear();
	}

	@Test(expected = NotesOuMotClesInexistantException.class)
	public void listeVideTest() throws NotesOuMotClesInexistantException {
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().clear();
		String st = gestionNotes.liste();
		
	}



	@Test
	public void editNouveau() throws NoteOuMotCleManquantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().clear();
		String st=gestionNotes.edit("trialeditnv","explContext","explproject");
		File f=new File(gestionNotes.getRepertoire(),"trialeditnv.adoc");
		assertTrue(f.exists());
		gestionNotes.getNotes().clear();
	}
	//Comment comparer
//	@Test
//	public void editExistantTest() throws NoteOuMotCleManquantException, IOException, ParseException
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//		gestionNotes.getNotes().clear();
//		String st=gestionNotes.edit("trialedit","explContext","explproject");
//
//		String titre="",contexte="",project="";
//		
//		FileInputStream fs = new FileInputStream (new File(gestionNotes.getRepertoire(),"trialedit.adoc"));
//        Scanner scanner = new Scanner(fs);
//        Pattern p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
//        String s="";
//        Date date=null;
//       while(scanner.hasNext())
//       {
//        String index = scanner.next();
//        Matcher m = p.matcher(index);
//        if(index.equals("="))
//        {
//        	titre = scanner.nextLine();
//
//        }
//        else if(m.find()) {
//        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        	date = sdf.parse(index);
//        }
//        else if(index.equals(":context:"))
//        {
//        	contexte = scanner.nextLine();
//        	System.out.println(contexte);
//
//        }
//        else if(index.equals(":project:"))
//        {
//        	project = scanner.nextLine();
//
//        }
//        else
//        {
//        	s += index;
//        	if(scanner.hasNext())
//        	{
//        		s += scanner.nextLine() + "\n";
//        	}
//
//        }
//      
//	}
//     assertEquals(gestionNotes.getNotes().get("trialedit").getContext(),"explcontext");
//     
//	}


	@Test(expected = NotesOuMotClesInexistantException.class)
	public void deleteFichierNonExistantTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException {
		GestionNotes gestionNotes = new GestionNotes();
		String del = gestionNotes.delete("FichierNonExistant.adoc");
		assertEquals(del, "");
		gestionNotes.getNotes().clear();
	}

	@Test
	public void deleteFichierExistantTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException {
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().put("trial1", new Notes.NoteBuilder("trial1").date(new Date(System.currentTimeMillis()))
				.context("").project("").build());
		String del = gestionNotes.delete("trial1");
		assertEquals(del, "trial1 a été supprimer");
		assertFalse(gestionNotes.getNotes().containsKey("trial1"));
		gestionNotes.getNotes().clear();
	}
	@Test
	public void configTest()
	{
		GestionNotes gestionNotes = new GestionNotes();
		String s=gestionNotes.config();
		assertEquals(s, "Edition de: " + ".configuration" + "....");
		gestionNotes.getNotes().clear();
	}
	@Test
	public void searchNonTrouveTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
	{
		GestionNotes gestionNotes = new GestionNotes();
		gestionNotes.getNotes().clear();
		gestionNotes.getNotes().put("trial1", new Notes.NoteBuilder("trial1").date(new Date(System.currentTimeMillis()))
				.context("").project("").contenu("hello").build());
		String s=gestionNotes.search("hello");
		assertEquals(s,"--------------------------------------------------------------------------------\n"+"Voici le resultat de la recherche:\n" + "\n"+"+ trial1"+ "\n"+"--------------------------------------------------------------------------------");
		gestionNotes.getNotes().clear();
	}
	
//	@Test
//	public void indexTest()
//	{
//		GestionNotes gestionNotes = new GestionNotes();
//		String st=gestionNotes.index();
//		assertEquals(st, "Lecture de: " + "index" + "....");
//	}
//	@Test
//	public void viewTest() throws NoteOuMotCleManquantException, NotesOuMotClesInexistantException
//	{
//
//		GestionNotes gestionNotes = new GestionNotes();
//		gestionNotes.getNotes().clear();
//		gestionNotes.getNotes().put("trial1",new Notes.NoteBuilder("trial1").date(new Date(System.currentTimeMillis())).context("").project("").build());
//		String st=gestionNotes.view("trial1");
//		assertEquals(st,"Lecture de: " + "trial1:" + "....");
//		
//	}

}