package robin_tarabay_boudo_slimani.notes;

import java.io.File;

/**
 * ViewNotesCommand.java : Classe permettant de visualiser les notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class ViewNotesCommand implements Command {
	
	private String note;
	
	/**
	 * Constructeur ViewNotesCommand
	 * @param note : le nom de la note
	 */
	public ViewNotesCommand(String note)
	{
		this.note = note;
	}
	/**
	 * Permet d'exécuter la commande de view qui affiche une note
	 */
	public void execute()
	{
		try
		{
			
			String nomDuSysthem = System.getProperty("os.name");
			System.out.println(nomDuSysthem);
			
			Runtime proc1 = Runtime.getRuntime();
			File fichier = new File("fc");
			String path = fichier.getCanonicalPath();
			path = path.substring(0, path.length() - 2);
			System.out.println(path);
			
			proc1.exec("asciidoctor " + path + Notes.repertoire + "/" + this.note + ".adoc");
			proc1.toString();
			proc1.toString();
			proc1.exec("google-chrome "+ path + Notes.repertoire + "/" + this.note + ".html");
//			proc1.exec("firefox "+ path + Notes.repertoire + "/" + this.note + ".html");
		}catch (Exception e)
		{
			e.getMessage();
		}
	}

	/**
	 * Récupère le nom de la note
	 * @return le nom de la note
	 */
	public String getNote()
	{
		return this.note;
	}
		

}
