
import java.io.*;
import java.util.ArrayList;
import lab_3b_1.CollectionOfBooks;
    public class FileManager {
    
    private final String fileName;
    FileOutputStream merh = null;
    ObjectOutputStream merhOut;
    
    FileInputStream finality = null;
    ObjectInputStream finalityOis = null;
    
    CollectionOfBooks theCollection;
    public FileManager(String fileName_){
        this.fileName = fileName_;
        /*try{
            merh = new FileOutputStream(fileName_);
            merhOut = new ObjectOutputStream(merh);
        }
        catch(Exception e){
            System.out.println("Unable to find file");
        }
        finally {
            try {
                if(merh!= null) merh.close();
            }
            catch(IOException e){}
        }*/
    }
  
    
    void connectToBooks(CollectionOfBooks newCollections){
        theCollection = newCollections;
    }
    public CollectionOfBooks load(){
        try{
            finality = new FileInputStream(fileName);
            finalityOis = new ObjectInputStream(finality); 
            theCollection = (CollectionOfBooks) finalityOis.readObject();
        } 
        catch(IOException e){
            System.out.println(e);
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
     }
    }
    public void save(CollectionOfBooks toSave) {
        try{
            merhOut.writeObject(toSave);
        }
        catch(Exception e){
            System.out.println(e);
        }
         finally {
            try {
                if(merh!= null) merh.close();
            }
            catch(IOException e){}
        }
    }
}
