package robin_tarabay_boudo_slimani.notes;

import java.io.IOException;
import java.util.*;

/**
 * SaisieNotes.java : Classe permettant de saisir des notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */


public class SaisieCommand {
	
	private Scanner saisie;
	private final Map<String, Command> commands;
	
	/**
	 * Constructeur par défaut
	 */
	public SaisieCommand()
	{
		this.saisie = new Scanner(System.in);
		this.commands = new HashMap<>();
	}
	
	/**
	 * Permet de stocker et d'exécuter la commande
	 * @param cmd qui permet de passer une cmd en paramètre
	 */
	public void storeAndExecute(String nom, Command cmd)
	{
		this.commands.put(nom, cmd);
	    this.commands.get(nom).execute();   
	}
	
	public void executeCommand(String nom)
	{
		this.commands.get(nom).execute();       
	}
	
	public void saisieUser(String[] args)
	{
		if(args.length != 0)
		{
//			String s = saisie.nextLine();
			String cmd = args[0];
			String note = args[1];
			System.out.println(cmd);
			System.out.println(note);
			
			
//			try
//			{
//					
//			}catch(IOException e)
//			{
//				System.out.println(e.getMessage());
//			}
				
			switch (cmd)
			{
				case "edit":
				case "e":
					if(this.commands.containsKey(note))
					{
						executeCommand(note);
					}
					else
					{
						Command command = new EditNotesCommand(note);
						storeAndExecute(note, command);
					}
					break;
						
				case "view":
				case "v":
					if(this.commands.containsKey(note))
					{
						System.out.println("if");
						executeCommand(note);
					}
					else
					{
						System.out.println("else");
						Command command = new ViewNotesCommand(note);
						storeAndExecute(note, command);
					}
					break;

				default:
					break;
				}
			}
		else
		{
//			afficheInfo();
//			String s = saisie.nextLine();
			String cmd = saisie.next();
			String note = saisie.nextLine();
			System.out.println(cmd);
			System.out.println(note);
			
			switch (cmd)
			{
				case "edit":
				case "e":
					if(this.commands.containsKey(note))
					{
						executeCommand(note);
					}
					else
					{
						Command command = new EditNotesCommand(note);
						storeAndExecute(note, command);
					}
					break;
						
				case "view":
				case "v":
					if(this.commands.containsKey(note))
					{
						System.out.println("if");
						executeCommand(note);
					}
					else
					{
						System.out.println("else");
						Command command = new ViewNotesCommand(note);
						storeAndExecute(note, command);
					}
					break;

				default:
					break;
				}
		}

		
	}
	
	public static void main( String[] args )
    {
    	
//    	Notes test = new Notes.NoteBuilder("Ma première Note").build();
//    	System.out.println(test.toString());
//    	ViewNotesCommand cmd = new ViewNotesCommand("Test");
//    	cmd.execute();
    	SaisieCommand saisie = new SaisieCommand();
    	saisie.saisieUser(args);
    }
}
