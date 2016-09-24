package lab_3b_1;

/**
 * An instance of this class represents an author containing just a name for now.
 * 
 * @author Tiago Redaelli <tiagor@kth.se> and Alexander Nordlund.
 */

public class Author {
    private String name;
   
    public Author() {
        this.name = "";
    }
   
    public Author(String name_) {
        this.name = name_;
    }
   
    public void setName(String name_) {
        this.name = name_;
    }
   
    public String getName() {
        return this.name;
    }
}
