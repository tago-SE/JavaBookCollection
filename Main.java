package lab_3b_1;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoOptionException  {
        CollectionOfBooks collection;
        
        FileManager fileManager = new FileManager("some_file_name"); 
        
        // if no file was found do: // Catch exception
            collection = new CollectionOfBooks();
        // else do:
            // collection = fileManager.load();
        // endif
        
        UserInterface ui = new UserInterface(collection);
                System.out.println(collection.toString());
        while (ui.runMainMenu()) {
            // Empty
        }
        
        // tells the program to save the file coming from ui.getUserChanges
        collection = ui.getUserChanges();
        fileManager.save(collection);
    }
}
