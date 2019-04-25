package robin_tarabay_boudo_slimani.notes;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;


/**
 * GestionNotes.java : classe principale qui exécute le programme
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class GestionNotes 
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
	public GestionNotes()
	{
		this.notes = new HashMap<> ();
		try {
			File fichier = new File("fc");
			String path = fichier.getCanonicalPath();
			path = path.substring(0, path.length() - 2);
			
			File rep = new File (path + repertoire);
			rep.mkdirs();
			System.out.println("rep = "+rep.getCanonicalPath());
			path += repertoire;
			this.repertoire = path;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Map<String, Notes> getNotes() {
		return notes;
	}

	/**
	 * Fonction qui permet de lister le contenu du dossier Document
	 */
	public void liste() {
		// foction de vérification
		
		if(!this.notes.isEmpty()) {
		
			Set<String> list = this.notes.keySet();
			Iterator<String> iterator = list.iterator();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Voici la liste de vos notes:\n");
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				System.out.println("+ " + this.notes.get(key).getNom());
				
			}
			System.out.println("--------------------------------------------------------------------------------");
		}
		else
		{
//			System.out.println(this.notes.size());
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
		System.out.println("Lecture de: " + nom + "....");
		try
		{	
//			String nomDuSystem = System.getProperty("os.name");
//			System.out.println(nomDuSystem);
			
			Runtime proc1 = Runtime.getRuntime();
			File noteAdoc = new File (repertoire, nom +".adoc");
			String laNoteAdoc = noteAdoc.getCanonicalPath();
			proc1.exec("asciidoctor " + laNoteAdoc);
			
			File f = new File(repertoire, nom + ".html");
			while(!f.exists() && !f.isFile())
			{
				
			}
			File noteHtml = new File (repertoire, nom +".html");
//			String laNoteHtml = noteHtml.getCanonicalPath();
			
//			proc1.exec("firefox "+ path + repertoire + "/" + nom + ".html");
//			proc1.exec("xdg-open " + laNoteHtml);
			Desktop.getDesktop().browse(noteHtml.toURI());
			
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
		

//		if(!this.notes.containsKey(nom))
//		{
//			this.notes.put(nom,new Notes.NoteBuilder(nom).build());
////			System.out.println(this.notes.toString());
//		}

		try
		{
			System.out.println("Edition de: " + nom + "....");
			File note = new File (repertoire, nom +".adoc");
			String laNote = note.getCanonicalPath();
			if (!note.exists())
			{
				note.createNewFile();
				FileWriter fw = new FileWriter(laNote);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("= "+this.notes.get(nom).getNom()+"\n"+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+"\n"+":context: "+this.notes.get(nom).getContext()+"\n"+":project: "+this.notes.get(nom).getProject());
				bw.close();
			}
			
			Runtime proc1 = Runtime.getRuntime();
			proc1.exec("code " + laNote);
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
				File adoc = new File (repertoire, nom +".adoc");
				File html = new File (repertoire, nom +".html");
				adoc.delete();
				html.delete();
				Notes o  = (Notes) this.notes.remove(nom);
				System.out.println( o.getNom() + " a été supprimer" );
			}catch (Exception e)
			{
				e.getMessage();
			}
			
		}
		
		
	}
	
	public void search(String mot) {
		Set<String> list = this.notes.keySet();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext())
		{
			Object key = iterator.next();
			if(this.notes.get(key).getNom().contains(mot)         ||
			   this.notes.get(key).getContext().contains(mot)     ||
			   this.notes.get(key).getProject().contains(mot)     ||
			   this.notes.get(key).getContenu().contains(mot)
					) {
				System.out.println(this.notes.get(key).getNom());
			}
			
		}
	}
		
	public void actualiserTable() {
		try {
			this.notes.clear();
			File dossier = new File(repertoire);
			
			if(dossier.exists() && dossier.isDirectory())
			{
				String s = "";
				String index = "";
				String titre = "";
				Date date = null;
				String project = "";
				String contexte = "";
				boolean b = true;
			    String liste[] = dossier.list();      
				
					    if (liste != null && liste.length != 0) {         
					        for (int i = 0; i < liste.length; i++)
					        {
					        	if(liste[i].contains(".adoc"))
					        	{
//					        		System.out.println(liste[i]);
					        		try( FileInputStream fs = new FileInputStream (new File(repertoire, liste[i]));
					                        Scanner scanner = new Scanner(fs))
					                {
					        			Pattern p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
					        			
//					        			System.out.println(repertoire + "/"+liste[i]);
					                    while(scanner.hasNext())
					                    {
//					                    	System.out.println("while");
					                        index = scanner.next();
					                        Matcher m = p.matcher(index);
					                        if(index.equals("=") && b)
					                        {
					                        	titre = scanner.nextLine();
//					             bd8304e           	System.out.println("titre = " + titre);
					                        	b = false;
					                        }
					                        else if(m.find()) {
					                        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					                        	date = sdf.parse(index);
					                        }
					                        else if(index.equals(":context:"))
					                        {
					                        	contexte = scanner.nextLine();
//					                        	System.out.println("contexte = " + project);
					                        }
					                        else if(index.equals(":project:"))
					                        {
					                        	project = scanner.nextLine();
//					                        	System.out.println("project = " + project);
					                        }
					                        else
					                        {
					                        	s += index;
					                        	if(scanner.hasNext())
					                        	{
					                        		s += scanner.nextLine() + "\n";
					                        	}
//					                        	System.out.println("la note contien: \n" + "\n" + s);
//					                        	System.out.println("else");
					                        }
					                        
					                    }
					                    fs.close();
					                    scanner.close();
//					                    System.out.println("\n fin if");
					                }
//		                        	System.out.println("\n fin de boucle");
//					        		System.out.println("\n la note contien: \n" + "\n" + s);
					        		this.notes.put(liste[i].substring(0, liste[i].length()-5),new Notes.NoteBuilder(titre)
					        																			.date(date)
					        																			.context(contexte)
					        																			.project(project)
					        																			.contenu(s)
					        																			.build());
					        		s = "";
					        		b = true;
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
	
}
