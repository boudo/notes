package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class TestNotes {
	
	@Test
	public void TestInstanceBuilder() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").build();
		
		assertNotNull(test);
	}
	
	@Test
	public void TestBuilderDefault() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").build();
		
		assertEquals("Ma première Note", test.getNom());
	}
	
	@Test
	public void TestBuilderDefault2() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").build();
		
		assertEquals("", test.getContenu());
	}
	
	@Test
	public void TestBuilderDate() throws ParseException {
		
		Date d = null;
		String index = "22/06/1992";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	d = sdf.parse(index);
		Notes test = new Notes.NoteBuilder("Ma première Note").date(d).build();
		
		assertEquals(sdf.parse("22/06/1992"), test.getDate());
	}
	
	@Test
	public void TestBuilderProject() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").project("work").build();
		
		assertEquals("work", test.getProject());
	}
	
	@Test
	public void TestBuilderContext() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").context("cds").build();
		
		assertEquals("cds", test.getContext());
	}
	
	@Test
	public void TestBuilderContenu() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").contenu("contenu").build();
		
		assertEquals("contenu", test.getContenu());
	}
	
	@Test
	public void TestBuilderComplet() throws ParseException {
		Date d = null;
		String index = "22/06/1992";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	d = sdf.parse(index);
		Notes test = new Notes.NoteBuilder("Ma première Note").date(d).project("work").context("cds").contenu("contenu").build();
		
		assertEquals("Notes [nom=" + test.getNom() + ", date=" + test.getDate() +", project=" + test.getProject() + ", context=" + test.getContext() + ", contenu="
				+ test.getContenu() + "]", test.toString());
	}

}
