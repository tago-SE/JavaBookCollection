package lab_3b_1;
import java.util.ArrayList;
import java.util.Collections;
 
/**
 * An instance of this class represents a collection of books. With
 * 
 * @author Tiago Redaelli <tiagor@kth.se> and Alexander Nordlund.
 */
 
public class CollectionOfBooks {
   
    private ArrayList<Book> bookCollection;
    private FileManager filemanager;
     /*
     void setDealer(Dealer newDealer){
        oneDealer = newDealer;
    }
    void playerToDeck(Deck mainDeck){
         myDeck = mainDeck;
         myDeck.setPlayer(this);
    }
    */
 
    public CollectionOfBooks() {
        this.bookCollection = new ArrayList<>();
    }
   
    public void addBook(Book book) {
        this.bookCollection.add(book);
    }
   
    public void removeBook(Book book) {
        this.bookCollection.remove(book);            
    }
    
    public Book getBook(int index) {
        return this.bookCollection.get(index);
    }
   
    public ArrayList<Book> searchBookByIsbn(String keyword){
        ArrayList<Book> search = new ArrayList<>();
        for (Book b : this.bookCollection) {
            if (b.getIsbn().contains(keyword)) {
                search.add(b);
            }
        }
        Collections.sort(search);
        return search;
    }
   
    public ArrayList<Book> searchBookByAuthor(String keyword){
        ArrayList<Book> search = new ArrayList<>();
        for (Book b : this.bookCollection) {
            ArrayList<Author> author = b.getAuthors();
            for (Author a : author ) {
                if (a.getName().contains(keyword)) {
                    search.add(b);
                }
            }  
        }
        Collections.sort(search);
        return search;
    }
   
    public ArrayList<Book> searchBookByTitle(String keyword){
        ArrayList<Book> search = new ArrayList<>();
        for (Book b : this.bookCollection) {
            if (b.getTitle().contains(keyword)/*b.getIsbn() == keyword*/) {
                search.add(b);
            }
        }
        Collections.sort(search);
        return search;
    }
   
    public ArrayList <Book> getBooks() {
        return this.bookCollection;
    }
    
    @Override
    public String toString() {
        String info = "";
        for (Book b : this.bookCollection) {
            info += b.toString() + "\n";
        }
        return info;
    }
    
    public void append (CollectionOfBooks other) {
        for (Book b : other.getBooks()) {
            this.addBook(b);
        }
    }
}
