package robin_tarabay_boudo_slimani.notes;

public class JavadocCommand implements Command {
	
	private GestionNotes gestionNotes;
	
	public JavadocCommand(GestionNotes g)
	{
		this.gestionNotes = g;
	}

	@Override
	public String execute()
	{
		return this.gestionNotes.javadoc();
	}

}
