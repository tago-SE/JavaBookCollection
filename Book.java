package lab_3b_1;

/**
 *
 * @author Tiago Radaelli and Alexander Nordlund
 * @version 1.2
 * @since 2016
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Comparable<Book>, Serializable {
    /**
     * class contains data members
     * isbn,title,edition and price.
     * Serializable.
     */
    private String isbn;
    private String title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;				
    
	private static final long serialVersionUID = -9152366823741777802L;
          /**
          * Constructor of a Book Object.
          * No parameters. nullifies all
          * Data members.
          * One composite aggregate of type Author
          */
	 public Book() {
        this.isbn = "";
        this.title = "";
        this.edition = 0;
        this.price = 0.0;
        this.authors = new ArrayList<>();
       
        }
	 /**
          * Overloaded constructor of a Book Object.
          * @param isbn_, the isbn of a new Book.
          * @param title_, the name of the Book.
          * @param edition_,the edition of the Book
          * @param price_, the price of the Book
          */
	public Book(String isbn_, String title_, int edition_, double price_) {
        this.isbn = isbn_;
        this.title = title_;
        this.edition = edition_;
        this.price = price_;
        this.authors = new ArrayList<Author>();
       
    }
   
        /**
          *  public method to establish isbn
          * @param isbn_ sets up isbn of the book
          */
   
    public void setIsbn(String isbn_) {
        this.isbn = isbn_;

    }
        /**
          * public method to establish title of Book
          * @param title_ sets up title of the book
          */
    public void setTitle(String title_) {
        this.title = title_;
         
    }
        /**
          * public method to establish edition of Book
          * @param edition_ sets up edition of the book
          */
    public void setEdition(int edition_) {
        this.edition = edition_;
     
    }
        /**
          * public method to establish price of Book
          * @param price_ sets up edition of the book
          */
    public void setPrice(double price_) {
        this.price = price_;
        
    }
   
        /**
          * method to return isbn of Book.
          * @return isbn.
          */
   
    public String getIsbn() {
        return this.isbn;
        
    }
         /**
          * method to return title of Book.
          * @return title.
          */
    public String getTitle() {
        return this.title;
    }
        /**
          * method to return edition of Book.
          * @return edition.
          */
    public int getEdition() {
        return this.edition;
         
    }
          /**
          * method to return price of Price.
          * @return price.
          */
    public double getPrice() {
        return this.price;

    }
   
   
        /**
          * This method adds a name to our
          * composite aggregate list of type author.
          * @param name_.
          */
    public void addAuthor(String name_) {
        this.authors.add(new Author(name_));
 
    }
        /**
          * This method searches by name the author
          * we wish to remove/delete.
          * @param name_, name of Author whose Book
          * will be eliminated in the collection
          */
    public void removeAuthor(String name_) {
        for (Author author : authors) {
            if (author.toString() == name_) {
                this.authors.remove(author);
            }
        }
 
    }
        /**
          *  Method that removes authors
          * @return authors 
          */
    public ArrayList<Author> getAuthors() {
        return this.authors;
     
    }
         /**
          * This method returns a string of all information
          * regarding every Book recorded, including isbn, price
          * edition,title and author.
          * @return string
          */
    @Override
    public String toString() {
        String s = "Title: " + this.getTitle() + " Edition: " + this.getEdition() + " ISBN: " + this.getIsbn() + " Price: " + this.getPrice() + "\n" +"Author(s): ";
        int i = 0;
        for (Author author : authors) {
            if (i > 0) {
                s += ",";
            }
            s += " " + author.getName();
            i++;
        }
        System.out.println();
        return s;
    }
        /**
          *  Redefinition of the compareToMethod as provided by the
          *  Comparable interface.
          *  @return an integer that is either higher or lower than zero.
          *  if it is zero then it is the same object.
          */
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);

    }
}
