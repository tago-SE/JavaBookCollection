package lab_3b_1;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoOptionException  {
        
        public static void main(String[] args) throws NoOptionException, IOException {	  	
           
             // Creates the file manager with a serialization file to read from.
            FileManager filemanager = new FileManager("file.ser");     
            
            // Deserialize (load) a collection of books from the file manager or returns an empty collection.
            CollectionOfBooks collection = filemanager.loadFromFile();	
            
            // Creates the user interface and sends the collection of books over to be handled internaly until finished. 
            UserInterface ui = new UserInterface(collection);

            // Run the program until user commands exit.
            while(ui.runMainMenu()){
                // Empty
            }
            
            // Gets all the changes to the menu from user interface.
            collection = ui.getUserChanges();
            
            // Saves the collection of books. 
            filemanager.saveToFile(collection);
     }
}
