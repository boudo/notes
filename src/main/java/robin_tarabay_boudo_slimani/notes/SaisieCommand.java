package robin_tarabay_boudo_slimani.notes;

import java.util.*;

/**
 * SaisieCommand.java : Classe permettant de saisir des notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class SaisieCommand {
	
	private Scanner saisie;
	private final Map<String, Command> commands;
	private GestionNotes gestionNotes;
	
	/**
	 * Constructeur par défaut
	 * @param g qui prend en paramètre GestionNotes
	 */
	public SaisieCommand(GestionNotes g)
	{
		this.saisie = new Scanner(System.in);
		this.commands = new HashMap<>();
		this.gestionNotes = g;
	}
	
	
	/**
	 * Permet de stocker et d'exécuter la commande
	 * @param nom qui permet de passer un nom en paramètre
	 * @param cmd qui permet de passer une cmd en paramètre
	 * @return  le nom de la commande stockée et l'exécute
	 * @throws NoteManquantException une exception
	 */
	public String storeAndExecute(String nom, Command cmd) throws NoteManquantException
	{
		this.commands.put(nom, cmd);
	    return this.commands.get(nom).execute();   
	}
	
	/**
	 * Permet d'executer la commande
	 * @param nom qui permet de passer un nom en paramètre
	 * @return  le nom de la commande exécutée
	 * @throws NoteManquantException une exception
	 */
	public String executeCommand(String nom) throws NoteManquantException
	{
		return this.commands.get(nom).execute();       
	}
	
	/**
	 * Permet d'afficher le Menu
	 */
	public void afficheInfo()
	{
//		design();
		design1();
//		design2();
//		design3();
//		design4();
		System.out.println("Bienvenue sur notre application de prises de Notes !\n\n"+
		"	Voici les différentes commandes que vous pouvez effectuer:\n\n"+
		"		-Créer ou éditer un Fichier: Tapez e ou edit suivi du nom de votre Fichier \n"+
		"		-Créer ou éditer un Fichier avec un project et/ou contexte: Tapez e ou edit suivi du nom de votre Fichier suivi de -p nom de votre project et/ou -c nom de votre contexte(Ordre sans importance) \n"+
		"		-Visualiser un Fichier: Tapez v ou view suivi du nom de votre Fichier\n"+
		"		-Lister le contenu du répertoire Document: Tapez ls ou list\n"+
		"		-Supprimer un Fichier: Tapez d ou delete suivi du nom de votre Fichier\n"+
		"		-Supprimer un Fichier: Tapez d ou delete suivi du nom de votre Fichier\n"+
		"		-Rechercher un mot-clé: Tapez s ou search suivi du mot ou de la phrase que vous recherchez dans les notes présentes\n"+
		"		-Consulter le manuel technique: Tapez doc ou javadoc pour consulter le manuel technique\n"+
		"		-Consulter le fichier index: Tapez index pour afficher les notes triées par context,project et date \n"+
		"		-Modifier le fichier de configuration: Tapez conf ou configuration pour pouvoir modifier le fichier de configuration selon vos préférences\n"+
		"		-Quitter le programme: Tapez q ou exit pour fermer l'application\n\n"+
		"		-Remarque: Toutes ces commandes sont aussi directement disponibles en ligne de commandes ! :)\n");
		
		System.out.println("Que souhaitez-vous faire? ");
	}
	
	/**
	 * Permet d'afficher le design
	 */
	public void design()
	{
		System.out.println("\n" + 
				"\n" + 
				"		 __    __              __                         \n" + 
				"		/  \\  /  |            /  |                        \n" + 
				"		$$  \\ $$ |  ______   _$$ |_     ______    _______ \n" + 
				"		$$$  \\$$ | /      \\ / $$   |   /      \\  /       |\n" + 
				"		$$$$  $$ |/$$$$$$  |$$$$$$/   /$$$$$$  |/$$$$$$$/ \n" + 
				"		$$ $$ $$ |$$ |  $$ |  $$ | __ $$    $$ |$$      \\ \n" + 
				"		$$ |$$$$ |$$ \\__$$ |  $$ |/  |$$$$$$$$/  $$$$$$  |\n" + 
				"		$$ | $$$ |$$    $$/   $$  $$/ $$       |/     $$/ \n" + 
				"		$$/   $$/  $$$$$$/     $$$$/   $$$$$$$/ $$$$$$$/  \n" + 
				"		                                                  \n" + 
				"   		                                               \n" + 
				"           		                                       \n" + 
				"\n" + 
				"");
	}
	
	/**
	 * Permet d'afficher le design1
	 */
	public void design1()
	{
		System.out.println("\n" + "\n" +
		
		"		███╗   ██╗ ██████╗ ████████╗███████╗███████╗	\n" +
		"		████╗  ██║██╔═══██╗╚══██╔══╝██╔════╝██╔════╝	\n" +
		"		██╔██╗ ██║██║   ██║   ██║   █████╗  ███████╗	\n" +
		"		██║╚██╗██║██║   ██║   ██║   ██╔══╝  ╚════██║	\n" +
		"		██║ ╚████║╚██████╔╝   ██║   ███████╗███████║	\n" +
		"		╚═╝  ╚═══╝ ╚═════╝    ╚═╝   ╚══════╝╚══════╝	\n" +
		"\n" + "\n");
	}
	
	/**
	 * Permet d'afficher le design2
	 */
	public void design2()
	{
		System.out.println("\n" + "\n" +
				
				
		"		 ██████   █████    ███████    ███████████ ██████████  █████████ 		\n" +
		"		 ░░██████ ░░███   ███░░░░░███ ░█░░░███░░░█░░███░░░░░█ ███░░░░░███		\n" +
		"		  ░███░███ ░███  ███     ░░███░   ░███  ░  ░███  █ ░ ░███    ░░░ 		\n" +
		"		  ░███░░███░███ ░███      ░███    ░███     ░██████   ░░█████████ 		\n" +
		"		  ░███ ░░██████ ░███      ░███    ░███     ░███░░█    ░░░░░░░░███		\n" +
		"		  ░███  ░░█████ ░░███     ███     ░███     ░███ ░   █ ███    ░███		\n" +
		"		  █████  ░░█████ ░░░███████░      █████    ██████████░░█████████ 		\n" +
		"		 ░░░░░    ░░░░░    ░░░░░░░       ░░░░░    ░░░░░░░░░░  ░░░░░░░░░  		\n" +
		"		                                                                 		\n" +
		"		                                                                 		\n" +
				
		"\n");
	}
	
	/**
	 * Permet d'afficher le design3
	 */
	public void design3()
	{
		System.out.println("\n" + "\n" +
	
		"	  	  __    __   ______   ________  ________   ______  		\n" +
		"		 /  \\  /  | /      \\ /        |/        | /      \\ 		\n" +
		"		 $$  \\ $$ |/$$$$$$  |$$$$$$$$/ $$$$$$$$/ /$$$$$$  |		\n" +
		"		 $$$  \\$$ |$$ |  $$ |   $$ |   $$ |__    $$ \\__$$/ 		\n" +
		"		 $$$$  $$ |$$ |  $$ |   $$ |   $$    |   $$      \\ 		\n" +
		"		 $$ $$ $$ |$$ |  $$ |   $$ |   $$$$$/     $$$$$$  |		\n" + 
		"		 $$ |$$$$ |$$ \\__$$ |   $$ |   $$ |_____ /  \\__$$ |		\n" +
		"		 $$ | $$$ |$$    $$/    $$ |   $$       |$$    $$/ 		\n" +
		"		 $$/   $$/  $$$$$$/     $$/    $$$$$$$$/  $$$$$$/  		\n" +
		"		                                                   		\n" +
		"		                                                  		\n" +
		"\n");
	}
	
	/**
	 * Permet d'afficher le design4
	 */
	public void design4()
	{
		System.out.println("\n" + "\n" +
				
				
                
		"		ooooo      ooo   .oooooo.   ooooooooooooo oooooooooooo  .oooooo..o 		\n" +
		"		`888b.     `8'  d8P'  `Y8b  8'   888   `8 `888'     `8 d8P'    `Y8 		\n" +
		"		8 `88b.    8  888      888      888       888         Y88bo.      		\n" +
		"		8   `88b.  8  888      888      888       888oooo8     ``Y8888o.  		\n" +
		"		8     `88b.8  888      888      888       888    '         ``Y88b 		\n" +
		"		8       `888  `88b    d88'      888       888       o oo     .d8P 		\n" +
		"		o8o        `8   `Y8bood8P'      o888o     o888ooooood8 8``88888P'  		\n" +
        "\n"+
        "\n"         
		);
	}
	
	/**
	 * Permet l'interaction entre l'application et l'utilisateur
	 * @param args qui permet à l'utilisateur d'interagir avec l'application
	 */
	public void saisieUser(String[] args)
	{
		boolean exit = false;
		boolean q = false;
		boolean affiche = true;
		boolean init = true;
		String tmpNote = "";
		while(!exit && !q)
		{
			try
			{
				if(args.length != 0 && init == true)
				{
					String cmd = args[0];
					String note = "";
					String avecEspace = "";
					String projet = "";
					String context = "";
					if(args.length > 1) {
						note = note + args[1];
						avecEspace = avecEspace + args[1];
						int i = 2;
						while(i<args.length && !(args[i].equals("-c") || args[i].equals("-p"))) {
							note = note + args[i];
							avecEspace = avecEspace + " " + args[i];
							i=i+1;
						}
						while(i<args.length) {
							if(args[i].equals("-c")) {
								i++;
								context = args[i];
							} 
							if(args[i].equals("-p")) {
								i++;
								projet = args[i];
							}
							i++;
						}
					}
					init = false;
					affiche = false;
					if(this.gestionNotes.miseAJour())
					{
						this.commands.clear();
						gestionNotes.trier();
					}
					if(tmpNote.equals("conf"))
					{
						this.gestionNotes.configGestionnaire();
						this.gestionNotes.miseAJour();
						tmpNote = "";
					}
					
					else if(!tmpNote.equals("") && !tmpNote.equals("conf"))
					{
						this.gestionNotes.initialiser(tmpNote);
						gestionNotes.trier();
						tmpNote = "";
					}
					switch (cmd)
					{
						case "edit":
						case "e":
							if(this.commands.containsKey(note+" "+cmd))
							{
								System.out.println( executeCommand(note+" "+cmd) );
								tmpNote = note;
							}
							else
							{
//								this.gestionNotes.getNotes().put(note,new Notes.NoteBuilder(note).date(new Date(System.currentTimeMillis())).context(context).project(projet).build());
								Command command = new EditNotesCommand(gestionNotes,note, context, projet);
								System.out.println( storeAndExecute(note+" "+cmd, command) );
								tmpNote = note;
							}
							
	//						System.out.println("tmpNote =" + tmpNote);
							break;
								
						case "view":
						case "v":
							if(this.commands.containsKey(note+" "+cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(note+" "+cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new ViewNotesCommand(gestionNotes,note);
								System.out.println( storeAndExecute(note+" "+cmd, command) );
							}
							break;
							
						case "list":
						case "ls":
							if(this.commands.containsKey(cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new ListNotesCommand(gestionNotes);
								System.out.println( storeAndExecute(cmd, command) );
							}
							break;
							
						case "delete":
						case "d":
							if(this.commands.containsKey(note+" "+cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(note+" "+cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new DeleteNotesCommand(gestionNotes,note);
								System.out.println( storeAndExecute(note+" "+cmd, command) );
							}
							this.commands.remove(note+" "+cmd);
							break;
							
						case "search":
						case "s":
							if(this.commands.containsKey(note+" "+cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(note+" "+cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new SearchNotesCommand(gestionNotes,avecEspace);
								System.out.println( storeAndExecute(note+" "+cmd, command) );
							}
							break;
							
						case "javadoc":
						case "doc":
							if(this.commands.containsKey(cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new JavadocCommand(gestionNotes);
								System.out.println( storeAndExecute(cmd, command) );
							}
							break;
							
						case "configuration":
						case "conf":
							if(this.commands.containsKey(cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new ConfigurationCommand(gestionNotes);
								System.out.println( storeAndExecute(cmd, command) );
								
							}
							tmpNote = "conf";
							break;
							
						case "index":
							if(this.commands.containsKey(cmd))
							{
	//							System.out.println("if");
								System.out.println( executeCommand(cmd) );
							}
							else
							{
	//							System.out.println("else");
								Command command = new IndexCommand(gestionNotes);
								System.out.println( storeAndExecute(cmd, command) );
							}
							break;
							
						case "exit":
						case "q":
							exit = true;
							break;
							
							
	
						default:
							break;
						}
					}
				else
				{   
					if(affiche)
					{
						afficheInfo();
						affiche = false;
					}
					String phrase = saisie.nextLine();
					String delims = "[ ]+";
					args = phrase.split(delims);
					init = true;
				}
			}catch(NoteManquantException e)
			{
				System.out.println(e.getMessage());
			}
		}
		saisie.close();
		

	}
	
	
}
