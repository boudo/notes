package robin_tarabay_boudo_slimani.notes;

import java.util.ArrayList;

public class Notes {
	
	private final String nom;
	private final String project;
	private final String context;
	
	public Notes(NoteBuilder builder)
	{
		nom = builder.nom;
		project = builder.project;
		context = builder.context;
	}
	
public static class NoteBuilder{
		
		private String nom;
		private String project;
		private String context;
		
		public NoteBuilder(String n)
		{
			nom = n;
			project = "";
			context = "";
		}
		
		public NoteBuilder project(String p)
		{
			project = p;
			return this;
		}
		
		public NoteBuilder context(String c)
		{
			context = c;
			return this;
		}
		
		public Notes build()
		{
			return new Notes(this);
		}	
	
	}

public String getNom() {
	return nom;
}

public String getProject() {
	return project;
}

public String getContext() {
	return context;
}

@Override
public String toString() {
	return "Notes [nom=" + nom + ", project=" + project + ", context=" + context + "]";
}
}
