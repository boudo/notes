package robin_tarabay_boudo_slimani.notes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.asciidoctor.Asciidoctor.Factory.create;
import org.asciidoctor.Asciidoctor;

/**
 * App.java : classe principale qui exécute le programme
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */

public class App 
{
	
	/**
	 * Fonction permettant de supprimer les warnings
	 */
//	@SuppressWarnings("unchecked")
//    public static void disableAccessWarnings() {
//        try {
//            Class unsafeClass = Class.forName("sun.misc.Unsafe");
//            Field field = unsafeClass.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            Object unsafe = field.get(null);
//
//            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
//            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);
//
//            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
//            Field loggerField = loggerClass.getDeclaredField("logger");
//            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
//            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
//        } catch (Exception ignored) {
//        }
//    }
	
	/**
	 * Fonction principale du programme 
	 * @param args pour récupérer les commandes saisies par l'utilisateur
	 */
    public static void main( String[] args )
    {
//    	disableAccessWarnings();
//    	Asciidoctor asciidoctor = create();
    	
    	Notes test = new Notes.NoteBuilder("Ma première Note").build();
    	System.out.println(test.toString());
    	ViewNotesCommand cmd = new ViewNotesCommand("Test");
    	cmd.execute();
    }
}
