package lab_3b_1;

/**
 *
 * @author tiago
 */
public class UserInterface {
    
    private Menu mainMenu;
    private CollectionOfBooks collection;
    private FileManager manager;
    public UserInterface(CollectionOfBooks books) {
        this.mainMenu = new Mainmenu("Main menu");
        this.collection = books;
        this.mainMenu.addOption("Add");
        this.mainMenu.addOption("Remove");
        this.mainMenu.addOption("List");
        this.mainMenu.addOption("Search");
        this.mainMenu.addOption("Save and exit");
        // Debug
        for (Book b : this.collection.getBooks()) {
            System.out.println(b.toString());
        }
    }
    /* /*
      void setDealer(Dealer newDealer){
        oneDealer = newDealer;
    }
    void dealerToDeck(Deck theDeck){ 
        deck = theDeck;           
        deck.setDealer(this); //deck has 'a dealer'
    }*/
    void hookUItoFileManager(FileManager UsersFiles){
        manager = UsersFiles; 
        System.out.println("Done");
    }
    public CollectionOfBooks getUserChanges() {
        return this.collection;
    }
    
    public boolean runMainMenu() throws NoOptionException {
        this.mainMenu.print();
        switch (this.mainMenu.getUserOption()) {
            case 1: this.collection.append(this.mainMenu.addBooks());  
                    //manager.save(collection);
                    break;
            case 2: this.collection = this.mainMenu.removeBooks(this.collection); 
                    break; 
            case 3: this.mainMenu.listBooks(collection);
                    break;
            case 4: this.mainMenu.searchBooks(collection);
                    break;
            case 5: manager.save(collection);
                    return false; // don't rerun
            default:  throw new NoOptionException();
        }
        return true;
    }
}
