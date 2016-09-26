package lab_3b_1;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoOptionException  {
        
        public static void main(String[] args) throws NoOptionException, IOException {	  	
           
            FileManager filemanager = new FileManager();
            
            // Loads the book collcetion from 
            CollectionOfBooks collection = filemanager.loadFromFile();	
            UserInterface ui = new UserInterface(collection);

           // ui.hookUItoFileManager(filemanager);
            while(ui.runMainMenu()){
                //
            }
            filemanager.saveToFile(collection);
            collection = ui.getUserChanges();
     }
}
