package lab_3b_1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Menu is a object to create menus with a header and options to display
 * and get the user to select a option. 
 * 
 * @author Tiago Redaelli and Alexander Nordlund
 * @version 1.2
 * @since 1.0
 */

public class Menu {
    
    /** 
     * Private data members: header and options.
     * header is the String label for the Menu.
     * options is a ArrayList of Strings with option labels. 
     */
    
    private String header;
    private ArrayList<String> options;
    
    /**
     * Creates a menu with the label header_
     * @param header_ 
     */
    
    public Menu(String header_) {
        this.header = header_;
        this.options = new ArrayList<>();
    }

    /**
     * Displays the menu, header and options.
     */
    public void print() {
        System.out.println(this.header);
        Iterator<String> it = options.iterator();
        int i = 0;
        while (it.hasNext()) {
            System.out.println(++i + ": " + it.next());
        }
    }
    
    /**
     * adds a string as option in the options ArrayList.
     * @param dialogue 
     */
    
    public void addOption(String dialogue) {
        this.options.add(dialogue);
    }
   
    /**
     * Recursively tries to get a user option until successful. 
     * @return option 
     * @InvalidUserInputException ex, if the user input is not of type Integer. 
     */
    
    public int getUserOption() {
        System.out.print("Option: ");
        int option;
        try {
            option =  UserInput.getInt();
        } catch (InvalidUserInputException ex) {
            // If invaild User Input exception try again. 
            return this.getUserOption();
        }
        if (option <= 0 || option > this.options.size()) {
            // If outside option bounds display result and try again.
            System.out.println("Outside bounds.");
            return this.getUserOption();
        }
        return option;
    }

    //    Useless methods I couldn't get rid of for some reason ... will remove...
   
    public CollectionOfBooks addBooks(CollectionOfBooks collection){
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CollectionOfBooks removeBooks(CollectionOfBooks collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void listBooks(CollectionOfBooks collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void searchBooks(CollectionOfBooks collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public void saveAndExit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
