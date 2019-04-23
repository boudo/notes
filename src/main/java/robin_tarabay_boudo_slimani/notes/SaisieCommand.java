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
	 * @param a qui prend en paramètre App
	 */
	public SaisieCommand(GestionNotes a)
	{
		this.saisie = new Scanner(System.in);
		this.commands = new HashMap<>();
		this.gestionNotes = a;
	}
	
	/**
	 * Permet de stocker et d'exécuter la commande
	 * @param nom qui permet de passer un nom en paramètre
	 * @param cmd qui permet de passer une cmd en paramètre
	 */
	public void storeAndExecute(String nom, Command cmd)
	{
		this.commands.put(nom, cmd);
	    this.commands.get(nom).execute();   
	}
	
	/**
	 * Permet d'executer la commande
	 * @param nom qui permet de passer un nom en paramètre
	 */
	public void executeCommand(String nom)
	{
		this.commands.get(nom).execute();       
	}
	
	/**
	 * Permet d'afficher le Menu
	 */
	public void afficheInfo()
	{
		design1();
		design2();
		design3();
		design4();
		System.out.println("Bienvenue sur notre application de prises de Notes !\n\n"+
		"	Voici les différentes commandes que vous pouvez effectuer:\n\n"+
		"		-Créer ou éditer un Fichier: Tapez e ou edit suivi du nom de votre Fichier \n"+
		"		-Visualiser un Fichier: Tapez v ou view suivi du nom de votre Fichier\n"+
		"		-Lister le contenu du répertoire Document: Tapez ls ou list\n"+
		"		-Supprimer un Fichier: Tapez d ou delete suivi du nom de votre Fichier \n");
		
		System.out.println("Que souhaitez-vous faire? ");
	}
	
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
		while(!exit && !q)
		{
			if(args != null && args.length != 0)
			{
//				String s = saisie.nextLine();
				String cmd = args[0];
				String note = "";
				if(args.length != 1)
				{
					 note = args[1];
				}
//				System.out.println(cmd);
//				System.out.println(note);
				
				
//				try
//				{
//						
//				}catch(IOException e)
//				{
//					System.out.println(e.getMessage());
//				}
					
				switch (cmd)
				{
					case "edit":
					case "e":
						if(this.commands.containsKey(note+" "+cmd))
						{
							executeCommand(note+" "+cmd);
						}
						else
						{
							Command command = new EditNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						args = null;
						break;
							
					case "view":
					case "v":
						if(this.commands.containsKey(note+" "+cmd))
						{
//							System.out.println("if");
							executeCommand(note+" "+cmd);
						}
						else
						{
//							System.out.println("else");
							Command command = new ViewNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						args = null;
						break;
						
					case "list":
					case "ls":
						if(this.commands.containsKey(cmd))
						{
//							System.out.println("if");
							executeCommand(cmd);
						}
						else
						{
//							System.out.println("else");
							Command command = new ListNotesCommand(gestionNotes);
							storeAndExecute(cmd, command);
						}
						args = null;
						break;
						
					case "delete":
					case "d":
						if(this.commands.containsKey(note+" "+cmd))
						{
//							System.out.println("if");
							executeCommand(note+" "+cmd);
						}
						else
						{
//							System.out.println("else");
							Command command = new DeleteNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						args = null;
						break;
						
					case "exit":
					case "q":
						exit = true;
						args = null;
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
				String note = "";
				String cmd = saisie.next();
				if(cmd != "ls" || cmd != "list")
				{
					 note = saisie.nextLine();
				}
//				System.out.println(cmd);
//				System.out.println(note);
				 if(note.length() != 0)
				 {
					 note = note.substring(1,note.length());
				 }
				
				switch (cmd)
				{
					case "edit":
					case "e":
						if(this.commands.containsKey(note+" "+cmd))
						{
							executeCommand(note+" "+cmd);
						}
						else
						{
							Command command = new EditNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						break;
							
					case "view":
					case "v":
						if(this.commands.containsKey(note+" "+cmd))
						{
//							System.out.println("if");
							executeCommand(note+" "+cmd);
						}
						else
						{
//							System.out.println("else");
							Command command = new ViewNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						break;
						
					case "list":
					case "ls":
						if(this.commands.containsKey(cmd))
						{
//							System.out.println("if");
							executeCommand(cmd);
						}
						else
						{
//							System.out.println("else");
							Command command = new ListNotesCommand(gestionNotes);
							storeAndExecute(cmd, command);
						}
						break;
						
					case "delete":
					case "d":
						if(this.commands.containsKey(note+" "+cmd))
						{
//							System.out.println("if");
							executeCommand(note+" "+cmd);
						}
						else
						{
//							System.out.println("else");
							Command command = new DeleteNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
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
		}
		saisie.close();
		

	}
	
}
