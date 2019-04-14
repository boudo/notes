package robin_tarabay_boudo_slimani.notes;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestNotes {

	@Test
	public void TestInstance() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").build();
		
		assertNotNull(test);
	}
	
	@Test
	public void TestBuilderDefault() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").build();
		
		assertEquals("Ma première Note", test.getNom());
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
	public void TestBuilderComplet() {
		
		Notes test = new Notes.NoteBuilder("Ma première Note").project("work").context("cds").build();
		
		assertEquals("Notes [nom=" + test.getNom() + ", project=" + test.getProject() + ", context=" + test.getContext() + "]", test.toString());
	}

}
