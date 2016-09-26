package lab_3b_1;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu {
      private String header;
    private ArrayList<String> options;
    
    public Menu(String header_) {
        this.header = header_;
        this.options = new ArrayList<>();
    }

    public void print() {
        System.out.println(this.header);
        Iterator<String> it = options.iterator();
        int i = 0;
        while (it.hasNext()) {
            System.out.println(++i + ": " + it.next());
        }
    }
    
    public void addOption(String dialogue) {
        this.options.add(dialogue);
    }
   
    public int getUserOption() {
        System.out.print("Option: ");
        int option;
        try {
            option =  UserInput.getInt();
        } catch (InvalidUserInputException ex) {
            return this.getUserOption();
        }
        if (option <= 0 || option > this.options.size()) {
            System.out.println("Outside bounds.");
            return this.getUserOption();
        }
        return option;
    }

    
    //    Useless methods I couldn't get rid of for some reason
    
    
   
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

    CollectionOfBooks addBooks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
