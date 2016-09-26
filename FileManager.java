package lab_3b_1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * An instance of this class represents a collection of books. With
 * 
 * @author Tiago Redaelli <tiagor@kth.se> and Alexander Nordlund.
 */
public class FileManager {
    private String fileName;
    private FileOutputStream fout = null;
     
     
     public FileManager(String fileName_){
        /**
          * Contructor of FileManger object. uses a string to name
          * the serial file to be used.
          */
         this.fileName = fileName_;
     }
          /**
           * @param collection all books we added that we are going to save
           * to file.
           * @throws Exeception
           * @throws IOException
           * @serialData collection (of books), outputs object to serial file.
           */
         
     public void saveToFile(CollectionOfBooks collection){

         try {
	      fout = new FileOutputStream(fileName);
	      ObjectOutputStream ous = new ObjectOutputStream(fout);
	      
	      ous.writeObject(collection);
	      
	      System.out.println("Serializing successfully completed");
	    }
	    catch (Exception e) {
	      System.out.println(e);
	    }
	    finally {
	    	try {
	    		if(fout != null) fout.close();
	    	}
	    	catch(IOException e) {}
	    } 
     }
         /**
           * @param collection all books we added that we are going to save
           * to file.
           * @throws ClassNotFoundException
           * @throws IOException
           * @serialData collection (of books), inputs object from serial file.
           */
         
     public CollectionOfBooks loadFromFile(){
         FileInputStream fin = null;
         CollectionOfBooks theCollection = new CollectionOfBooks();
         try{
             fin = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fin);
             theCollection = (CollectionOfBooks) ois.readObject();
             System.out.println("Deserializing");
         }
         catch(IOException e){
             System.out.println(e);
         }
         catch(ClassNotFoundException e){
             System.out.println(e);
         }
         finally {
             try {
                 if(fin!=null)fin.close();
             }
             catch(IOException e){}
         }
         return theCollection;
     }
}
