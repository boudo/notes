package robin_tarabay_boudo_slimani.notes;


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
//			Process proc1 = Runtime.getRuntime().exec("asciidoctor " + this.note + ".adoc");
//			Process proc2 = Runtime.getRuntime().exec("firefox "+ this.note + ".html");
//			Process proc3 = Runtime.getRuntime().exec("google-chrome Test.html");
			
			Runtime proc1 = Runtime.getRuntime();
			proc1.exec("asciidoctor " + this.note + ".adoc");
			proc1.exec("firefox "+ this.note + ".html");
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
