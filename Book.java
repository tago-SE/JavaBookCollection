package lab_3b_1;
import java.util.ArrayList;

/**
 * An instance of this class represents a book containing information such
 * as ISBN number, title, edition price and author(s).
 * 
 * @author Tiago Redaelli <tiagor@kth.se> and Alexander Nordlund.
 */


public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;
   
    // Constructors
   
    public Book() {
        this.isbn = "";
        this.title = "";
        this.edition = 0;
        this.price = 0.0;
        this.authors = new ArrayList<>();
    }
   
    public Book(String isbn_, String title_, int edition_, double price_) {
        this.isbn = isbn_;
        this.title = title_;
        this.edition = edition_;
        this.price = price_;
        this.authors = new ArrayList<>();
    }
   
    // Set
   
    public void setIsbn(String isbn_) {
        this.isbn = isbn_;
    }
   
    public void setTitle(String title_) {
        this.title = title_;
    }
   
    public void setEdition(int edition_) {
        this.edition = edition_;
    }
   
    public void setPrice(double price_) {
        this.price = price_;
    }
   
    // Get
   
    public String getIsbn() {
        return this.isbn;
    }
   
    public String getTitle() {
        return this.title;
    }
   
    public int getEdition() {
        return this.edition;
    }
   
    public double getPrice() {
        return this.price;
    }
   
    // Author
   
    public void addAuthor(String name_) {
        this.authors.add(new Author(name_));
    }
   
    public void removeAuthor(String name_) {
        for (Author author : authors) {
            if (author.toString() == name_) {
                this.authors.remove(author);
            }
        }
    }
   
    public ArrayList<Author> getAuthors() {
        return this.authors;
    }
   
    @Override
    public String toString() {
        String s = "Title: " + this.getTitle() + "\nEdition: " + this.getEdition() + "\nISBN: " + this.getIsbn() + "\nPrice: " + this.getPrice() + "\nAuthor(s): ";
        int i = 0;
        for (Author author : authors) {
            if (i > 0) {
                s += ",";
            }
            s += " " + author.getName();
            i++;
        }
        return s;
    }
 
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}  
