package lab_3b_1;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoOptionException  {
        CollectionOfBooks collection;
        
         
       
        FileManager filemanager = new FileManager("files.ser");
        //f
        //if no file was found do: // Catch exception
        collection = new CollectionOfBooks();
        // else do:
            // collection = fileManager.load();
        // endif
      //  filemanager.connectToBooks(collection);
        //Association between collection and the other thing.
        UserInterface ui = new UserInterface(collection);
        ui.hookUItoFileManager(filemanager);
        System.out.println(collection.toString());
        while (ui.runMainMenu()) {
            // Empty
        }
        
        // tells the program to save the file coming from ui.getUserChanges
        collection = ui.getUserChanges();
        filemanager.load();
       // filemanager.save(collection);
    }
}
