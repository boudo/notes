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
		System.out.println("\n" + 
				"\n" + 
				" __    __              __                         \n" + 
				"/  \\  /  |            /  |                        \n" + 
				"$$  \\ $$ |  ______   _$$ |_     ______    _______ \n" + 
				"$$$  \\$$ | /      \\ / $$   |   /      \\  /       |\n" + 
				"$$$$  $$ |/$$$$$$  |$$$$$$/   /$$$$$$  |/$$$$$$$/ \n" + 
				"$$ $$ $$ |$$ |  $$ |  $$ | __ $$    $$ |$$      \\ \n" + 
				"$$ |$$$$ |$$ \\__$$ |  $$ |/  |$$$$$$$$/  $$$$$$  |\n" + 
				"$$ | $$$ |$$    $$/   $$  $$/ $$       |/     $$/ \n" + 
				"$$/   $$/  $$$$$$/     $$$$/   $$$$$$$/ $$$$$$$/  \n" + 
				"                                                  \n" + 
				"                                                  \n" + 
				"                                                  \n" + 
				"\n" + 
				"");
		System.out.println("Bienvenue sur notre application de prises de Notes !\n\n"+
		"	Voici les différentes commandes que vous pouvez effectuer:\n\n"+
		"		-Créer ou éditer un Fichier: Tapez e ou edit suivi du nom de votre Fichier \n"+
		"		-Visualiser un Fichier: Tapez v ou view suivi du nom de votre Fichier\n"+
		"		-Lister le contenu du répertoire Document: Tapez ls ou list\n"+
		"		-Supprimer un Fichier: Tapez d ou delete suivi du nom de votre Fichier \n");
		
		System.out.println("Que souhaitez-vous faire? ");
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
		while(!exit && !q)
		{
			if(args.length != 0 && init == true)
			{
				System.out.println("je suis la");
				String cmd = args[0];
				String note = "";
				String projet = "";
				String context = "";
				if(args.length > 1) {
					int i = 1;
					while(i<args.length && !(args[i].equals("-c") || args[i].equals("-p"))) {
						note = note + args[i];
						i=i+1;
					}
					while(i<args.length) {
						if(args[i].equals("-c")) {
							i=i+1;
							context = args[i];
						} 
						if(args[i].equals("-p")) {
							i=i+1;
							projet = args[i];
						}
						i=i+1;
					}
				}
				init = false;
				affiche = false;
				
					
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
							this.gestionNotes.getNotes().put(note,new Notes.NoteBuilder(note).context(context).project(projet).build());
							Command command = new EditNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						break;
							
					case "view":
					case "v":
						if(this.commands.containsKey(note+" "+cmd))
						{
							System.out.println("if");
							executeCommand(note+" "+cmd);
						}
						else
						{
							System.out.println("else");
							Command command = new ViewNotesCommand(gestionNotes,note);
							storeAndExecute(note+" "+cmd, command);
						}
						break;
						
					case "list":
					case "ls":
						if(this.commands.containsKey(cmd))
						{
							System.out.println("if");
							executeCommand(cmd);
						}
						else
						{
							System.out.println("else");
							Command command = new ListNotesCommand(gestionNotes);
							storeAndExecute(cmd, command);
						}
						break;
						
					case "delete":
					case "d":
						if(this.commands.containsKey(note+" "+cmd))
						{
							System.out.println("if");
							executeCommand(note+" "+cmd);
						}
						else
						{
							System.out.println("else");
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
		}
		
		saisie.close();
		
	}
	
}
