package robin_tarabay_boudo_slimani.notes;



/**
 * Notes.java est une classe représentant les notes crées par les utilisateurs
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class Notes {
	
	private final String nom;
	private final String project;
	private final String context;
	private final String contenu;
	
	
	/**
	 * Constructeur Notes
	 * @param builder qui fait appel au builder
	 */
	public Notes(NoteBuilder builder)
	{
		nom = builder.nom;
		project = builder.project;
		context = builder.context;
		contenu = builder.contenu;
	}
	
	/**
	 * NoteBuilder est une classe static représentant le builder 
	 */
public static class NoteBuilder{
		
		private String nom;
		private String project;
		private String context;
		private String contenu;
		
		/**
		 * Constructeur NoteBuilder par défaut
		 * @param n qui représente le nom de la note
		 */
		public NoteBuilder(String n)
		{
			nom = n;
			project = "";
			context = "";
			contenu = "";
		}
		
		/**
		 * Permet d'ajouter un project à une note
		 * @param p qui représente le project de la note
		 * @return this qui retourne la note avec l'attribut project
		 */
		public NoteBuilder project(String p)
		{
			project = p;
			return this;
		}
		
		/**
		 * Permet d'ajouter un context à une note
		 * @param c qui représente le context de la note
		 * @return this qui retourne la note avec l'attribut context
		 */
		public NoteBuilder context(String c)
		{
			context = c;
			return this;
		}
		
		/**
		 * Permet d'ajouter un contenu à une note
		 * @param ctn qui représente le contenu de la note
		 * @return this qui retourne la note avec sontenu
		 */
		public NoteBuilder contenuNote(String ctn)
		{
			context = ctn;
			return this;
		}
		
		/**
		 * Permet de construire le builder
		 * @return new Notes(this) : qui renvoie la note.
		 */
		public Notes build()
		{
			return new Notes(this);
		}	
	
	}

/**
 * Récupère le nom
 * @return nom : qui renvoie le nom 
 */
public String getNom() {
	return nom;
}

/**
 * Récupère le project
 * @return project : qui renvoie le project 
 */
public String getProject() {
	return project;
}

/**
 * Récupère le contexte
 * @return context : qui renvoie le context 
 */
public String getContext() {
	return context;
}

/**
 * Récupère le contexte
 * @return context : qui renvoie le context 
 */
public String getContenuNote() {
	return contenu;
}

/**
 * Affiche avec les paramètres de notes
 * @return les attributs de la note.
 */
@Override
public String toString() {
	return "Notes [nom=" + nom + ", project=" + project + ", context=" + context + "]";
}

}
