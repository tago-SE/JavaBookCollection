import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

 
/**
 * An instance of this class represents a collection of books. With
 * 
 * @author Tiago Redaelli <tiagor@kth.se> and Alexander Nordlund.
 */
 
public class CollectionOfBooks implements Serializable {
     /**
      * private data members : list of Books of type Book.
      * 
      */
    private ArrayList<Book> bookCollection;
   
        /**
          * constructor that creates object.
          * composite aggregate of type Book.
          */
    public CollectionOfBooks() {
        this.bookCollection = new ArrayList<>();
        
    }
        /**
           *  This method adds a book to our collection
           *  @param book, a book that has an edition,
           *  isbn, price, author and title
           * 
           */
    public void addBook(Book book) {
        this.bookCollection.add(book);
       
    }
         /**
           *  This method removes a book to our collection
           *  @param book, a book that has an edition,
           *  isbn, price, author and title
           * 
           */    
 
    public void removeBook(Book book) {
        this.bookCollection.remove(book);    
             
    }
         /**
           *  This method returns a book from our collection
           *  based on the index of that book we want returned.
           *  @param index, an integer that represents the index
           *  of book we want returned
           *  @return bookCollection.get(index) returns the book we 
           *  want, based on the index number
           * 
           */  
    public Book getBook(int index) {
        return this.bookCollection.get(index);
 
    }
         /**
           *  This method runs a search in our book collection for isbn(s)
           *  based on the inserted isbn of that book we want returned.
           *  @param index, keyword that is used to later find a match
           *  of book we want returned
           *  @return the closest match(es) to keyword if any exists
           *  
           */ 
 
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
   
         /**
           *  This method runs a search in our book collection for author(s)
           *  based on the inserted keyword of that book we want returned.
           *  @param index, keyword that is used to later find a match
           *  of book we want returned
           *  @return the closest match(es) to keyword if any exists
           *  
           */  
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
         /**
           *  This method runs a search in our book collection for title(s)
           *  based on the inserted keyword of that book we want returned.
           *  @param index, keyword that is used to later find a match
           *  of book we want returned
           *  @return the closest match(es) to keyword if any exists
           *  
           */  
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
    /**
          * Method that returns all books collected in a list
          * of type Book.
          * @return bookCollections.
          */
    public ArrayList <Book> getBooks() {
        return this.bookCollection;
        
    }
     /**
          * Method that redefines toString to allow
          * us to print information of every book collected.
          * 
          * 
          * @return info in form of String.
          */
    @Override
    public String toString() {
        String info = "";
        for (Book b : this.bookCollection) {
            info += b.toString() + "\n";
        }
        return info;
        
    }
    /** method that appends book
           * @param other. appends the list of book with a new book
           * 
           */
    public void append (CollectionOfBooks other) {
        for (Book b : other.getBooks()) {
            this.addBook(b);
        }
    }
}
