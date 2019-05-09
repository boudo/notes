package robin_tarabay_boudo_slimani.notes;

import java.util.Date;

/**
 * Notes.java est une classe représentant les notes crées par les utilisateurs
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class Notes {
	
	private final String nom;
	private final Date date;
	private final String nomUser;
	private final String email;
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
		date = builder.date;
		nomUser = builder.nomUser;
		email = builder.email;
		project = builder.project;
		context = builder.context;
		contenu = builder.contenu;
	}
	
	/**
	 * NoteBuilder est une classe static représentant le builder 
	 */
public static class NoteBuilder{
		
		private final String nom;
		private Date date;
		private String nomUser;
		private String email;
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
			contenu = "";
		}
		
		/**
		 * Permet d'ajouter une date à une note
		 * @param d qui représente la date de creation de la note
		 * @return this qui retourne la note avec l'attribut date
		 */
		public NoteBuilder date(Date d)
		{
			this.date = d;
			return this;
		}
		
		/**
		 * Permet d'ajouter un nom d'utilisateur à une note
		 * @param nUser qui représente le nom de l'utilisateur qui crée la note
		 * @return this qui retourne la note avec l'attribut nomUser
		 */
		public NoteBuilder nomUser(String nUser)
		{
			this.nomUser = nUser;
			return this;
		}
		
		/**
		 * Permet d'ajouter un email de l'utilisateur à une note
		 * @param e qui représente l'email de l'utilisateur qui crée la note
		 * @return this qui retourne la note avec l'attribut email
		 */
		public NoteBuilder email(String e)
		{
			this.email = e;
			return this;
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
		 * @return this qui retourne la note avec son contenu
		 */
		public NoteBuilder contenu(String ctn)
		{
			contenu = ctn;
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
 * Récupère le nom de l'utilisateur
 * @return nomUser : qui renvoie le nom de l'utilisateur 
 */
public String getNomUser() {
	return nomUser;
}

/**
 * Récupère l'email de l'utilisateur
 * @return email : qui renvoie l'email de l'utilisateur 
 */
public String getEmail() {
	return email;
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
 * Récupère la date de création
 * @return date : qui renvoie la date de création 
 */
public Date getDate() {
	return date;
}

/**
 * Récupère le contenu
 * @return contenu : qui renvoie le contenu 
 */
public String getContenu() {
	return contenu;
}

/**
 * Affiche avec les paramètres de notes
 * @return les attributs de la note.
 */
@Override
public String toString() {
	return "Notes [nom=" + nom + ", date=" + date + ", project=" + project + ", context=" + context + ", contenu="
			+ contenu + "]";
}

}
