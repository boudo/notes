package robin_tarabay_boudo_slimani.notes;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import robin_tarabay_boudo_slimani.Exception.NoteOuMotCleManquantException;
import robin_tarabay_boudo_slimani.Exception.NotesOuMotClesInexistantException;

//import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;


/**
 * GestionNotes.java : Classe qui permet de gérer les différentes notes contenues dans le dossier Document
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class GestionNotes 
{
	private Map<String,Notes> notes;
	private String repRacine;
	private String repertoire;// = "Document";
	private String navigateur;
	private String editeur;
	
	/**
	 * Constructeur par défaut
	 */
	public GestionNotes()
	{
		this.notes = new HashMap<> ();
		configGestionnaire();
		creerRepertoire();
		actualiserNotes();
		trier();
	}
	
/******************************************* COMMAND ************************************************/
	
	/**
	 * Fonction qui permet de lister le contenu du dossier Document
	 * @return le nom des notes présentes ou un message d'erreur
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String liste() throws NotesOuMotClesInexistantException {
		// foction de vérification
		String listeNote = "";
		if(!this.notes.isEmpty()) {
		
			Set<String> list = this.notes.keySet();
			Iterator<String> iterator = list.iterator();
			listeNote = "--------------------------------------------------------------------------------\n";
//			System.out.println("--------------------------------------------------------------------------------");
			listeNote += "Voici la liste de vos notes:\n" + "\n";
//			System.out.println("Voici la liste de vos notes:\n");
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				listeNote += "+ " + this.notes.get(key).getNom() + "\n";
//				System.out.println("+ " + this.notes.get(key).getNom());
				
			}
			listeNote += "--------------------------------------------------------------------------------";
//			System.out.println("--------------------------------------------------------------------------------");
		}
		else
		{
//			System.out.println(this.notes.size());
			
			throw new NotesOuMotClesInexistantException("Aucune Notes !\n");
			//listeNote = "Il n'y a aucune notes";
			//System.out.println("Il n'y a aucune notes");
		}
		return listeNote;
	}
	
	/**
	 * Fonction qui permet de visualiser une note
	 * @param nom qui prend en paramètre un nom
	 * @return le nom de la note consultée
	 * @throws NoteOuMotCleManquantException une exception
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String view(String nom) throws NoteOuMotCleManquantException,NotesOuMotClesInexistantException
	{	
		String lecture = "";
		if(this.notes.containsKey(nom))
		{
			lecture = "Lecture de: " + nom + "....";
//			System.out.println("Lecture de: " + nom + "....");
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
				String laNoteHtml = noteHtml.getCanonicalPath();
				
				proc1.exec(this.navigateur + " " + laNoteHtml);
//				Desktop.getDesktop().browse(noteHtml.toURI());
				
				
			}catch (Exception e)
			{
				return e.getMessage();
			}
		}
			
		else
		{
			throw new NotesOuMotClesInexistantException("ce Fichier n'existe pas !\n");
			//lecture = "Cette note n'existe pas";
//			System.out.println("Cette note n'existe pas");
		}
		return lecture;
	}
	
	/**
	 * Fonction qui permet d'éditer une note ou d'en créer une
	 * @param nom qui prend en paramètre un nom
	 * @param projet qui prend en paramètre un attribut projet
	 * @param context qui prend en paramètre un attribut contexte
	 * @return le nom de la note editée
	 * @throws NoteOuMotCleManquantException une exception
	 */
	public String edit(String nom, String context, String projet) throws NoteOuMotCleManquantException {
		

//		if(!this.notes.containsKey(nom))
//		{
//			this.notes.put(nom,new Notes.NoteBuilder(nom).build());
////			System.out.println(this.notes.toString());
//		}
		
		String edition = "";
		try
		{
			edition = "Edition de: " + nom + "....";
//			System.out.println("Edition de: " + nom + "....");
			File note = new File (repertoire, nom +".adoc");
			String laNote = note.getCanonicalPath();
			if (!note.exists())
			{
				note.createNewFile();
				FileWriter fw = new FileWriter(laNote);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("= "+ nom +"\n"+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+"\n"+
							":context: "+ context +"\n"+
							":project: "+ projet);
				bw.close();
			}
			
			Runtime proc1 = Runtime.getRuntime();
			proc1.exec(this.editeur + " " + laNote);
		}catch (Exception e)
		{
			e.getMessage();
		}
		return edition;
	}
	
	/**
	 * Fonction qui permet de supprimer une note 
	 * @param nom qui prend en paramètre un nom
	 * @return le nom de la note supprimée ou un message d'erreur
	 * @throws NoteOuMotCleManquantException une exception
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String delete(String nom) throws NoteOuMotCleManquantException,NotesOuMotClesInexistantException
	{
		String del = "";
		if(!this.notes.containsKey(nom))
		{
			throw new NotesOuMotClesInexistantException("ce Fichier n'existe pas !\n");
			//del = "Ce Fichier n'existe pas";
//			System.out.println("Ce Fichier n'existe pas");
		}
		
		else {
			try
			{
				File adoc = new File (repertoire, nom +".adoc");
				File html = new File (repertoire, nom +".html");
				adoc.delete();
				html.delete();
				Notes o  = (Notes) this.notes.remove(nom);
				del = o.getNom() + " a été supprimer";
//				System.out.println( o.getNom() + " a été supprimer" );
				trier();
			}catch (Exception e)
			{
				e.getMessage();
			}
			
		}
		return del;
	}
	
	/**
	 * Fonction qui permet de rechercher un mot
	 * @param mot qui prend en paramètre un mot à rechercher
	 * @return la liste des fichiers contenant le mot-clé ou la phrase demandée
	 * @throws NoteOuMotCleManquantException une exception
	 * @throws NotesOuMotClesInexistantException une exception
	 */
	public String search(String mot) throws NoteOuMotCleManquantException,NotesOuMotClesInexistantException
	{
		
//		System.out.println("le mot =" + mot);
		boolean trouver = false;
		String sear = "--------------------------------------------------------------------------------\n";
		sear += "Voici le resultat de la recherche:\n" + "\n";
		Set<String> list = this.notes.keySet();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext())
		{
			Object key = iterator.next();
			if(this.notes.get(key).getNom().contains(mot)         ||
			   this.notes.get(key).getContext().contains(mot)     ||
			   this.notes.get(key).getProject().contains(mot)     ||
			   this.notes.get(key).getContenu().contains(mot)
					)
			{
				sear += "+ " + this.notes.get(key).getNom() + "\n";
				trouver = true;
//				System.out.println(this.notes.get(key).getNom());
			}
			
		}
		sear += "--------------------------------------------------------------------------------";
		if(!trouver)
		{
			throw new NotesOuMotClesInexistantException("Mot-clé Introuvable !\n");
		}
		return sear;
	}
	
	/**
	 * Fonction qui permet d'afficher la javadoc
	 * @return la javadoc dans le navigateur
	 */
	public String javadoc()
	{
		Runtime proc1 = Runtime.getRuntime();
		try
		{
			proc1.exec(this.navigateur+ " target/apidocs/" + "index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Lecture de la documentation java de l'application...\n";
	}
	
	/**
	 * Fonction qui permet de modifier le fichier de configuration
	 * @return le fichier de configuration
	 */
	public String config()
	{
		
		String conf = "";
		try
		{
			conf = "Edition de: " + ".configuration" + "....";
//			System.out.println("Edition de: " + nom + "....");
			File note = new File (".configuration");
			String laNote = note.getCanonicalPath();
			
			Runtime proc1 = Runtime.getRuntime();
			proc1.exec(this.editeur + " " + laNote);
		}catch (Exception e)
		{
			e.getMessage();
		}
		return conf;
	}
	
	/**
	 * Fonction qui permet de visualiser le fichier index.adoc dans le navigateur
	 * @return le fichier index dans le navigateur
	 */
	public String index()
	{
		String conf = "";
		try
		{
			conf = "Lecture de: " + "index" + "....";
			File test = new File ("index.html");
			if(test.exists() && test.isFile())
			{
				test.delete();
			}
			Runtime proc1 = Runtime.getRuntime();
			File noteAdoc = new File ("index.adoc");
			String laNoteAdoc = noteAdoc.getCanonicalPath();
			proc1.exec("asciidoctor " + laNoteAdoc);
			
			File f = new File("index.html");
			while(!f.exists() && !f.isFile())
			{
				
			}
			File noteHtml = new File ("index.html");
			String laNoteHtml = noteHtml.getCanonicalPath();
			
			proc1.exec(this.navigateur + " " + laNoteHtml);
		}catch (Exception e)
		{
			e.getMessage();
		}
		return conf;
	}


/******************************************* INITIALISATION ************************************************/
	
	
	/**
	 * Fonction qui permet de creer le dossier
	 */
	public void creerRepertoire()
	{
		try {
			File fichier = new File("","fc");
//			System.out.println(fichier.getAbsolutePath()); 
			String path = fichier.getCanonicalPath();
			path = path.substring(0, path.length() - 2);
			
			File repRacin = new File (path, this.repRacine);
			String path1 = repRacin.getCanonicalPath();
			File rep = new File (path1, this.repertoire);
			rep.mkdirs();
			this.repertoire = rep.getCanonicalPath();
			actualiserNotes();
		} catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	
	
	/**
	 * Fonction qui permet d'actualiser le contenu de la liste de notes en fonction du contenu du dossier
	 */
	public void actualiserNotes() {
		try {
//			this.notes.clear();
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
//					                        	System.out.println("titre = " + titre);
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
					        		this.notes.put(liste[i].substring(0, liste[i].length()-5),new Notes.NoteBuilder(titre.substring(1, titre.length()))
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

	/**
	 * Fonction qui permet d'initialiser une note à partir du dossier Document
	 * @param note qui prend en paramètre une note
	 */
	public void initialiser(String note)
	{
		try {
//			this.notes.clear();
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
				
					    if (liste != null && liste.length != 0)
					    {         
					        for (int i = 0; i < liste.length; i++)
					        {
					        	if(liste[i].contains(".adoc") && liste[i].substring(0, liste[i].length()-5).equals(note))
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
//					                        	System.out.println("titre = " + titre);
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
//					        		System.out.println("titre =" + titre);
					        		this.notes.put(liste[i].substring(0, liste[i].length()-5),new Notes.NoteBuilder(titre.substring(1, titre.length()))
					        																			.date(date)
					        																			.context(contexte)
					        																			.project(project)
					        																			.contenu(s)
					        																			.build());
					        		break;
					        	}
					        }
					        trier();
					    }
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}

	}
	
	/**
	 * Fonction qui permet de mettre à jour l'application pour vérifier que tout est fonctionnel.
	 * @return misajour renvoie true ou false
	 */
	public boolean miseAJour()
	{
		boolean misAjour = false;
//		System.out.println("mise ajour");
//		System.out.println(repertoire);
		File dossier = new File(repertoire);
		
		if(dossier.exists() && dossier.isDirectory())
		{
//			System.out.println("dans if 1");
//			System.out.println(this.notes.toString());
			String liste[] = dossier.list();
			if(liste != null && liste.length != 0 && !this.notes.isEmpty())
			{
				List<String> listeDyn = new ArrayList<String>();
				for(int i = 0; i < liste.length; i++)
				{
					if(liste[i].contains(".adoc"))
		        	{
						listeDyn.add(liste[i].substring(0, liste[i].length()-5));
		        	}
				}
//				System.out.println("après for");
				Map<String,Notes> tmp = new HashMap<> ();
				tmp.putAll(notes);
				Set<String> list = tmp.keySet();
				Iterator<String> iterator = list.iterator();
				String note = "";
//				System.out.println("debut while");
				while(iterator.hasNext())
				{
					Object key = iterator.next();
					note = tmp.get(key).getNom();
//					System.out.println("note =" + note);
					if(!listeDyn.contains(note))
					{
//						System.out.println("debut if 2");
						Notes o  = (Notes) this.notes.remove(note);
						File html = new File (repertoire, note +".html");
						if(html.exists() && html.isFile())
						{
							html.delete();
						}
						misAjour = true;
						System.out.println( o.getNom() + " a été supprimer manuellement dans " + repertoire );
						
					}
//					System.out.println("fin if 2");
				}
//				System.out.println("après while");
				if(misAjour)
				{
					trier();
				}
			}
			else
			{
				this.notes.clear();
				misAjour = true;
			}
		}
		else
		{
			creerRepertoire();
//			dossier.mkdirs();
			this.notes.clear();
			misAjour = true;
		}
		return misAjour;
	}
	
	/**
	 * Fonction qui permet de créer le fichier de configuration
	 */
	public void configGestionnaire()
	{
//		System.out.println("\n sui dans sonfig\n");
		try( FileInputStream fs = new FileInputStream (new File(".configuration"));
                Scanner scanner = new Scanner(fs))
        {
			String index ="";
			String rep ="";
			String repRacin ="";
			String editeur = "";
			String navig ="";
			while(scanner.hasNext())
			{
				index = scanner.next();
				if(index.equals("RACINE:"))
				{
					repRacin = scanner.next();
//					System.out.println("repRacin =" + repRacin);
					setRepRacine(repRacin);
				}
				else if(index.equals("REPERTOIRE:"))
				{
					rep = scanner.next();
//					System.out.println("rep =" + rep);
					setRepertoire(rep);
				}
				else if(index.equals("EDITEUR:"))
				{
					editeur = scanner.next();
//					System.out.println("editeur =" + editeur);
					setEditeur(editeur);
				}
				else if(index.equals("NAVIGATEUR:"))
				{
					navig = scanner.next();
//					System.out.println("navig =" + navig);
					setNavigateur(navig);
				}
			}
			
        } catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void modeConfiguration()
	{
		this.notes.clear();
		configGestionnaire();
		creerRepertoire();
		actualiserNotes();
	}
	
	
/******************************************* GET ET SET ************************************************/
	

	/**
	 * Permet de récupérer les notes
	 * @return notes qui renvoie les notes
	 */
	public Map<String, Notes> getNotes() {
		return notes;
	}
	
	/**
	 * Permet de modifier le repertoire
	 * @param rep qui prend un nom de repertoire en argument
	 */
	public void setRepertoire(String rep)
	{
		this.repertoire = rep;
		
	}

	/**
	 * Permet de modifier l'editeur
	 * @param editeur qui prend un nom d'editeur en argument
	 */
	public void setEditeur(String editeur)
	{
		this.editeur = editeur;
		
	}

	/**
	 * Permet de modifier le navigateur
	 * @param navig qui prend un nom de navigateur en argument
	 */
	public void setNavigateur(String navig)
	{
		this.navigateur = navig;
		
	}
	
	/**
	 * Permet de modifier la racine
	 * @param repRacin qui prend un nom de racine en argument
	 */
	public void setRepRacine(String repRacin)
	{
		this.repRacine = repRacin;
	}
	

	/**
	 * Fonction qui permet de trier dans le fichier index.adoc
	 */
	public void trier()
	{
//		System.out.println("\n Tri \n");
		List<Notes> listnotes = new ArrayList<Notes>();
		Set<String> list = this.notes.keySet();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext())
		{
			Object key = iterator.next();
			listnotes.add(this.notes.get(key));
		}
		//System.out.println(listnotes.toString()+"\n\n");
		Collections.sort(listnotes, new Comparator<Notes>() {
		    @Override
		    public int compare(Notes n1, Notes n2) {
		    	return n1.getNom().compareTo(n2.getNom());
		    }
		});
		Collections.sort(listnotes, new Comparator<Notes>() {
		    @Override
		    public int compare(Notes n1, Notes n2) {
		    	if(n1.getContext().compareTo(n2.getContext()) == 0 && n1.getProject().compareTo(n2.getProject()) == 0){
		    		Calendar calendar1 = new GregorianCalendar();
			        calendar1.setTime(n1.getDate());
			        Calendar calendar2 = new GregorianCalendar();
			        calendar2.setTime(n2.getDate());
		    		return calendar1.get(Calendar.MONTH) - calendar2.get(Calendar.MONTH);
		    	} else if(n1.getContext().compareTo(n2.getContext()) == 0) {
		    		return n1.getProject().compareTo(n2.getProject());
		    	} else {
		    		return n1.getContext().compareTo(n2.getContext());
		    	}
		    }
		});
		//System.out.println(listnotes.toString());
		try {
			File note = new File ("index.adoc");
			String laNote = note.getCanonicalPath();
			if (!note.exists())
			{
				note.createNewFile();
			}
			FileWriter fw = new FileWriter(laNote);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("= Index" + "\n" + "\n");
			for(int i=0; i<listnotes.size(); i++)
			{
				if(i == 0 || listnotes.get(i-1).getContext().compareTo(listnotes.get(i).getContext()) != 0) {
					bw.write(". Context: "+listnotes.get(i).getContext()+"\n");
				}
				if(i == 0 || listnotes.get(i-1).getProject().compareTo(listnotes.get(i).getProject()) != 0) {
					bw.write(".. Project: "+listnotes.get(i).getProject()+"\n");
				}
				File lien = new File (this.repertoire, listnotes.get(i).getNom() + ".html");
				if(lien.exists() && lien.isFile())
				{
					String leLien = lien.getCanonicalPath();
					bw.write("***  link:"+ leLien + "["+ listnotes.get(i).getNom() + "]" +"\n");
				}
				else
				{
					bw.write("*** " + listnotes.get(i).getNom() +"\n");
				}
			}
			bw.close();
		}catch (Exception e) {
			e.getMessage();
		}
		
	}
	
}
