package lab_3b_1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Mainmenu is an object that extends menu and uses it's own methods unique to 
 * the options from this type of menu. 
 * 
 * @author Tiago Redaelli and Alexander Nordlund
 * @version 1.2
 * @since 1.0
 */

public class Mainmenu extends Menu {
    
    /**
     * Creates a Mainmenu with the lable header_
     * @param header_ 
     */
    public Mainmenu(String header_) {
        super(header_);
    }
    
    /**
     * Creates a bland menu with only one option to return to main menu.
     */
    
    private void simpleWaitBeforeReturnMenu() {
        Menu menu = new Menu("Back to Main Menu?");
        menu.addOption("Yes");
        menu.print();
        menu.getUserOption();
    }
  
    /**
     * RemoveBooks creates a sub menu with all the books for the user to remove
     * as well as a initial option of returning to main menu. 
     * @param books, recieves a CollectionOfBooks to possibly modify. 
     * @return books, the changed collectionOfBooks.
     */
    public CollectionOfBooks removeBooks(CollectionOfBooks books) {
        
        // Creates an iterrator of type CollectionOfBooks.
        Iterator<Book> it = books.getBooks().iterator();
        
        // if the List is empty display results and ask if the user wants to return
        if (!(it.hasNext())) {
            System.out.println("<Empty List>");
            this.simpleWaitBeforeReturnMenu();
            return books;
        } 
        
        // Createss the sub-menu (remove) with the option to retrn to main menu
        // and the list with all the books.
        Menu removeMenu = new Menu("Remove Menu ");
        removeMenu.addOption("Back to Main Menu");
        
        // Iterates through all the books and add them as an option to the remove-menu. 
        while (it.hasNext()) {
            removeMenu.addOption("Remove: " + it.next().toString());
        } 
        
        removeMenu.print();
        int option = removeMenu.getUserOption();
        
        // Option: Exit (return)
        if (option == 1) {
            return books;  
        }
        
        // Remove book and dispay results
        Book b = books.getBook(option - 2);
        books.removeBook(b);
        System.out.println("Removed: " + b.toString());
        return books;
    }
    
    /**
     * listBooks is an option that displays all the collected books to the user. 
     * @param books, recieves a CollectionOfBooks to display.
     */

    public void listBooks(CollectionOfBooks books) {
        
        // Creates an iterrator of type CollectionOfBooks.
        Iterator<Book> it = books.getBooks().iterator();
        
        // if there is no collection.
        if (!(it.hasNext())) {
            System.out.println("<Empty List>");
        } 
        // Otherwise iterate through all books and display them.
        else {
            System.out.println("Book List");
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            } 
        }
        
        // Wait for resposne when finished.
        this.simpleWaitBeforeReturnMenu();
    }
    
    /**
     * searchBooks is an option that creates a sub-menu for the user to chose 
     * how to search and afterwards executes the search and/or returns to main menu. 
     * 
     * @param books, recieves a CollectionOfBooks to search in.
     */
    
    public void searchBooks(CollectionOfBooks books) {
        Menu searchMenu = new Menu("Search Menu");
        searchMenu.addOption("Search by ISBN");
        searchMenu.addOption("Search by Author");
        searchMenu.addOption("Search by Title");
        searchMenu.addOption("Back to Main Menu");
        searchMenu.print();
        
        int option = searchMenu.getUserOption();
        String key; // Search key 
        ArrayList<Book> searchResult;   // the result of what was foubd.
        switch (option) {
            case 1: key = UserInput.askForStr("Enter search: ");
                    searchResult = books.searchBookByIsbn(key);
                    break;
            case 2: key = UserInput.askForStr("Enter search: ");
                    searchResult = books.searchBookByAuthor(key);
                    break;
            case 3: key = UserInput.askForStr("Enter search: ");
                    searchResult = books.searchBookByTitle(key);
                    break;
            default: return; // Back to Main Menu if none of the above.
        }
        
        // No search result found
        if (searchResult.isEmpty() || key.length() == 0) {
            System.out.println("<No matches found>");
        }
        else {  
            // creates an interator form the result 
            Iterator<Book> it = searchResult.iterator();
            System.out.println("Search result:");
            while (it.hasNext()) {
                // Displays the result book by book.
                System.out.println(it.next().toString());
            }  
        }
        // Wait for resposne
        this.simpleWaitBeforeReturnMenu();
    }
    
    /**
     * saveAndExit is an option in the menu with no purpose right now.
     */
    
    public void saveAndExit() {
        // Empty, for future use maybe. 
    }    
 
    /** 
    * addBook prompts the user with a series of questions to add a new book to 
    * the collection.
     * @param collection, contains the book list to add the book to.  
     * @return col, the collection of books with the new book added. 
     */
    
    public CollectionOfBooks addBooks(CollectionOfBooks collection) {
        CollectionOfBooks col = new CollectionOfBooks();
        
        // The user interface for adding a book.
        System.out.println("Add Book");
        String title = UserInput.askForStr("Enter title: ");
        String isbn = UserInput.askForStr("Enter ISBN: ");
        double price = UserInput.askForDouble("Enter price: ");
        int edition = UserInput.askForInt("Enter edition: ");
        
        // Creates the book with the above input
        Book b = new Book(isbn, title, edition, price);
        
        System.out.println("Add authors. Enter nothing to finish.");
        String author;
        int i = 0;
        do {
            author = UserInput.askForStr("Author " + ++i + ": ");
            if (author.length() != 0) {
                b.addAuthor(author); 
            }
        } while (author.length()!= 0); // Continue until the user enters [ENTER].
        if (i == 1) {
            // If no author was added, it gets assigned to John Doe.
            b.addAuthor("John Doe"); 
        }
        // Displays the book to add.
        System.out.println("Book added. " + b.toString());   
        
        // Adds the book to col and returns the new collection.
        col.addBook(b);
        return col;
    }
}
