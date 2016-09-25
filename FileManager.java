package lab3.Lab3_2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import lab_3b_1.Book;
import lab_3b_1.CollectionOfBooks;

    public class FileManager implements Serializable{
    
    private String fileName;
 
    
    private CollectionOfBooks theCollection;
   
   
    public FileManager(String fileName_){
        System.out.println("MERH");
        this.fileName = fileName_;
      
    }
    
    
   // public CollectionOfBooks load(){
       /* System.out.println("Load");
        try{
            finality = new FileInputStream(fileName);
            System.out.println("Executed 1");
            finalityOis = new ObjectInputStream(finality); 
            System.out.println("Executed 2");
            CollectionOfBooks cob = (CollectionOfBooks) finalityOis.readObject();
            System.out.println("Executed 3");
            System.out.print(cob.toString());
            
        } 
        catch(IOException e){
            System.out.println(e+ "This type");
        }
        catch(ClassNotFoundException e){
            System.out.println("Negative Colonel");
        }
        finally {
            try{
               if(finality!=null)finality.close();
            }
        catch(IOException e){};
        return null;    // Throw exception if failed to load.
     }*/
   // }
    public void save(CollectionOfBooks toSave) {
        System.out.println("Saving");  
        ArrayList<Book> book = toSave.getBooks();
        FileOutputStream fout = null;
        
        try {
	      fout = new FileOutputStream(fileName);
	      ObjectOutputStream ous = new ObjectOutputStream(fout);
	      System.out.println("Up to here");
	      ous.writeObject(book);
	      
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
}
