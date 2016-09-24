package lab_3b_1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class Mainmenu extends Menu {
    
    public Mainmenu(String header_) {
        super(header_);
    }
    
    private void simpleWaitBeforeReturnMenu() {
        Menu menu = new Menu("Back to Main Menu?");
        menu.addOption("Yes");
        menu.print();
        menu.getUserOption();
    }
    
    public CollectionOfBooks addBooks() {
        CollectionOfBooks col = new CollectionOfBooks();
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
        } while (author.length()!= 0);
        if (i == 1) {
            b.addAuthor("None");
        }
        System.out.println("Book added. " + b.toString());   
        col.addBook(b);
        return col;
    }  
   
    public CollectionOfBooks removeBooks(CollectionOfBooks books) {
        Iterator<Book> it = books.getBooks().iterator();
        int i = 0;
        
        // The List is empty (return)
        if (!(it.hasNext())) {
            System.out.println("<Empty List>");
            this.simpleWaitBeforeReturnMenu();
            return books;
        } 
        
        // Prints a menu with all the books and the option to return.
        Menu removeMenu = new Menu("Remove Menu ");
        removeMenu.addOption("Back to Main Menu");
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

    public void listBooks(CollectionOfBooks books) {
        Iterator<Book> it = books.getBooks().iterator();
        if (!(it.hasNext())) {
            System.out.println("<Empty List>");
        } 
        else {
            System.out.println("Book List");
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            } 
        }
        // Wait for resposne
        this.simpleWaitBeforeReturnMenu();
    }
    
    public void searchBooks(CollectionOfBooks books) {
        // Check if empty...
        
        Menu searchMenu = new Menu("Search Menu");
        searchMenu.addOption("Search by ISBN");
        searchMenu.addOption("Search by Author");
        searchMenu.addOption("Search by Title");
        searchMenu.addOption("Back to Main Menu");
        searchMenu.print();
        
        int option = searchMenu.getUserOption();
        String key;
        ArrayList<Book> searchResult;
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
            default: return; // Back to Main Menu
        }
        
        // No search result
        if (searchResult.isEmpty() || key.length() == 0) {
            System.out.println("<No matches found>");
        }
        
        // Display search result
        else {
            Iterator<Book> it = searchResult.iterator();
            System.out.println("Search result:");
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }  
        }
        // Wait for resposne
        this.simpleWaitBeforeReturnMenu();
    }
    
    public void saveAndExit() {
        // Empty
    }    
}
