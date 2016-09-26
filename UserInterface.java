package lab_3b_1;

/**
 * UserInterface is an object that takes 
 * 
 * @author Tiago Redaelli and Alexander Nordlund
 * @version 1.2
 * @since 1.0
 */

public class UserInterface {
    
     /** 
     * Private data members: mainMenu, collection, manager
     * mainMenu contains information about the main menu.
     * collection is the collection of books sent in from main
     */
    
    private Menu mainMenu;
    private CollectionOfBooks collection;
    
    /**
     * UserInterface creates the user interface.
     * @param books, the collection of books from which the menu operates until complete. 
     */
    
    public UserInterface(CollectionOfBooks books) {
        this.mainMenu = new Mainmenu("Main menu");
        this.collection = books;
        this.mainMenu.addOption("Add");
        this.mainMenu.addOption("Remove");
        this.mainMenu.addOption("List");
        this.mainMenu.addOption("Search");
        this.mainMenu.addOption("Save and exit");        
    }
    
    /**
     * getUserChanges returns the collection of books that is stored inside the user interface.
     * @return this.collection, the collection of books stored in this class. 
     */
    
    public CollectionOfBooks getUserChanges() {
        return this.collection;
    }
    
    /**
     * runMainMenu displays the main menu and asks the user to chose a option.
     * @return boolean if to continue running the program or terminate (false).
     * @throws NoOptionException 
     */
    
    public boolean runMainMenu() throws NoOptionException {
        this.mainMenu.print();
        switch (this.mainMenu.getUserOption()) {
            case 1: this.collection.append(this.mainMenu.addBooks(this.collection));  
                    break;
            case 2: this.collection = this.mainMenu.removeBooks(this.collection); 
                    break; 
            case 3: this.mainMenu.listBooks(collection);
                    break;
            case 4: this.mainMenu.searchBooks(collection);
                    break;
            case 5: return false; // don't rerun
            default:  throw new NoOptionException();
        }
        return true;
    }
}
