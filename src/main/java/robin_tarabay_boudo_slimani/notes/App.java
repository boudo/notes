package robin_tarabay_boudo_slimani.notes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.asciidoctor.Asciidoctor.Factory.create;
import org.asciidoctor.Asciidoctor;
import java.util.Collections;
/*
 * Hello world!
 *
 */
import java.util.Date;
import java.util.Scanner;


public class App 
{
	@SuppressWarnings("unchecked")
    public static void disableAccessWarnings() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
        }
    }
    public static void main( String[] args )
    {
    	disableAccessWarnings();
    	Asciidoctor asciidoctor = create();

        
        if(args[0].toString().equals("edit"))
        {
            String fname = "";
            for(int i=1;i<args.length;i++)
            		fname=fname+""+args[i];
 
            	File tempFile = new File(fname);
  			  boolean exists = tempFile.exists();
  			  System.out.println("Existe: "+exists);
				if(exists)
				{
				   System.out.println( "Il existe avec le nom"+fname);
					try {
						  ProcessBuilder pb=new ProcessBuilder("/Applications/Visual Studio Code.app/Contents/MacOS/Electron",fname);
	        			   pb.start();
//						Process p = Runtime.getRuntime().exec("/Applications/TextEdit.app/Contents/MacOS/TextEdit","/Users/marianetarabay/eclipse-workspace/testprojet/src/main/java/testprojet/testprojet/marianetest.txt");
//						Desktop.getDesktop().open(tempFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				   ProcessBuilder pb=new ProcessBuilder("TextEdit.exe","mtest.txt");
//        			   pb.start();
//        			   File file = new File("/absolute/path/to/file.vlc");
//        			   Desktop.getDesktop().open(file);
				   
				}
				else
				{
					System.out.println("le fichier n'existe pas");
					try {
						String utilisateur,titre,emailu;
						Scanner sc = new Scanner(System.in); 
						System.out.println("Titre: ");						
						titre=sc.nextLine();
						System.out.println("Entrer le nom de l'utilisateur");
						utilisateur=sc.nextLine();
						System.out.println("Entrer mail de l'utilisateur:");
						emailu=sc.nextLine();
						tempFile.createNewFile();
						System.out.println("Le nouveau fichier a ete cree");
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						Date date = new Date();
						System.out.println(dateFormat.format(date));
				         FileWriter fw = new FileWriter(tempFile.getAbsoluteFile());
				         BufferedWriter bw = new BufferedWriter(fw);
				         bw.write("= "+titre);
				         bw.newLine();
				         bw.write(utilisateur+"<"+emailu+">");
				         bw.newLine();
				         bw.write(dateFormat.format(date));
				         bw.newLine();
				         bw.close();
						ProcessBuilder pb=new ProcessBuilder("/Applications/Visual Studio Code.app/Contents/MacOS/Electron",fname);
	        			   pb.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//        				Process p = Runtime.getRuntime().exec("/Applications/Octave-gui.app/Contents/MacOS/Octave");
				 
				}
        }
        else if(args[0].equals("delete"))
        {
            String fname = "";
            for(int i=1;i<args.length;i++)
            		fname=fname+""+args[i];
 
            	File tempFile = new File(fname);
  			  boolean exists = tempFile.exists();
  			  if(exists)
  			  {
  				  tempFile.delete();
  				  System.out.println("Le fichier a ete efface");
  			  }
  			  else
  			  {
  				  System.out.println("Le fichier n'existe pas");
  			  }
  			  
        }
     
    }
}
