
import java.io.*;
import java.util.ArrayList;
import lab_3b_1.CollectionOfBooks;
public class FileManager {
    private String fileName;
     FileOutputStream fout = null;
     public FileManager(){
        this.fileName = "N.ser";
     }
    
     public void saveToFile(CollectionOfBooks collection){
         ArrayList<Book> books = collection.getBooks();
         try {
	      fout = new FileOutputStream("N.ser");
	      ObjectOutputStream ous = new ObjectOutputStream(fout);
	      
	      ous.writeObject(books);
	      
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
     public void loadFromFile(){
         FileInputStream fin = null;
         try{
             fin = new FileInputStream("N.ser");
             ObjectInputStream ois = new ObjectInputStream(fin);
             ArrayList<Book> book = (ArrayList<Book>) ois.readObject();
             System.out.println("Deserializing");
             
             for(Book b : book){
                 System.out.println(b.toString());
             }
         }
         catch(IOException e){
             System.out.println(e);
         }
         catch(ClassNotFoundException e){
             System.out.println("MERH");
         }
         finally {
             try {
                 if(fin!=null)fin.close();
             }
             catch(IOException e){}
         }
     }
}

