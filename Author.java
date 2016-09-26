package lab_3b_1;
import java.io.Serializable;

/**
 *
 * @author Tiago Radaelli and Alexander Nordlund
 * @version 1.2
 * @since 2016
 */
public class Author implements Serializable{
    /**
    * Serializable class contains two private data fields
    * namely name (String) and the serialVersionUID
    */
    
    private String name;
    private static final long serialVersionUID = -9152366823741777802L;
       /**
         * constructor returns an empty String. 
         */
    public Author() {
        
        this.name = "";
    }
        /**
         * Overloaded constructor that
         * defines one data field. 
         */
    public Author(String name_) {
        
        this.name = name_;
    }
       
         /**
         *  Define a data field.
         * 
         */
    public void setName(String name_) {
        this.name = name_;
    }
        /**
         *  Return the data field,
         *  Representing the name
         *  of type String.
         */
    public String getName() {
       
        return this.name;
    }
}
