package robin_tarabay_boudo_slimani.notes;

import java.util.*;
import java.io.File;


/**
 * App.java : classe principale qui exécute le programme
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class App 
{
	/**
	 * Fonction principale du programme 
	 * @param args pour récupérer les commandes saisies par l'utilisateur
	 */
	private Map<String,Notes> notes;
	private String repertoire = "Document";
	
	/**
	 * Constructeur par défaut
	 */
	public App()
	{
		this.notes = new HashMap<> ();
		
		try {
			File fichier = new File("fc");
			String path = fichier.getCanonicalPath();
			path = path.substring(0, path.length() - 2);
			
			File dossier = new File(path+"/"+repertoire);
			
			if(dossier.exists() && dossier.isDirectory())
			{
			    String liste[] = dossier.list();      
				
					    if (liste != null && liste.length != 0) {         
					        for (int i = 0; i < liste.length; i++) {
					        	if(liste[i].contains(".adoc"))
					        	{
					        		this.notes.put(liste[i].substring(0, liste[i].length()-5),new Notes.NoteBuilder(liste[i].substring(0, liste[i].length()-5)).build());
					        	}
					        }
					    }
			}
			else {
				
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

	/**
	 * Fonction qui permet de lister le contenu du dossier Document
	 */
	public void liste() {
		
		
		if(!this.notes.isEmpty()) {
		
			Set<String> list = this.notes.keySet();
			Iterator<String> iterator = list.iterator();
			
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				System.out.println(this.notes.get(key).getNom());
				
			}
		}
		else
		{
			System.out.println(this.notes.size());
			System.out.println("Il n'y a aucune notes");
		}
	}
	
	/**
	 * Fonction qui permet de visualiser une note
	 * @param nom qui prend en paramètre un nom
	 */
	public void view(String nom) {
		
	if(this.notes.containsKey(nom))
	{
		try
		{	
			String nomDuSystem = System.getProperty("os.name");
			System.out.println(nomDuSystem);
			Runtime proc1 = Runtime.getRuntime();
			File fichier = new File("fc");
			String path = fichier.getCanonicalPath();
			path = path.substring(0, path.length() - 2);
			System.out.println(path);
			proc1.exec("asciidoctor " + path + repertoire + "/" + nom + ".adoc");
			//proc1.toString();
			//proc1.exec("google-chrome "+ path + repertoire + "/" + nom + ".html");
			
			File f = new File(path + repertoire + "/" + nom + ".html");
			while(!f.exists() && !f.isFile())
			{
				
			}
			proc1.exec("firefox "+ path + repertoire + "/" + nom + ".html");
			System.out.println("on est la");
		}catch (Exception e)
		{
			e.getMessage();
		}
	}
		
	else {
			
		System.out.println("Cette note n'existe pas");
	}
		
	}
	
	/**
	 * Fonction qui permet d'éditer une note ou d'en créer une
	 * @param nom qui prend en paramètre un nom
	 */
	public void edit(String nom) {
		
		if(!this.notes.containsKey(nom))
		{
			System.out.println("je suis la pour ajouter le nom");
			this.notes.put(nom,new Notes.NoteBuilder(nom).build());
			System.out.println(this.notes.toString());
		}
		
		
		try
		{
			System.out.println("edit");
			Runtime proc1 = Runtime.getRuntime();
			proc1.exec("mkdir -p " + repertoire);
			proc1.toString();
			proc1.exec("code " + repertoire + "/" + nom +".adoc");
		}catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	/**
	 * Fonction qui permet de supprimer une note 
	 * @param nom qui prend en paramètre un nom
	 */
	public void delete(String nom) {
		
		if(!this.notes.containsKey(nom))
		{
			System.out.println("Ce Fichier n'existe pas");
		}
		
		else {
			try
			{
				System.out.println("delete");
				File fichier = new File("fc");
				String path = fichier.getCanonicalPath();
				path = path.substring(0, path.length() - 2);
				System.out.println(path);
				File adoc = new File(path+ repertoire + "/" + nom +".adoc");
				File html = new File(path+ repertoire + "/" + nom +".html");
				adoc.delete();
				html.delete();
				Notes o  = (Notes) this.notes.remove(nom);
				System.out.println( o.getNom() + " à été supprimer" );
			}catch (Exception e)
			{
				e.getMessage();
			}
			
		}
		
		
	}
		
}
