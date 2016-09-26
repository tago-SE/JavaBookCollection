package lab_3b_1;

/**
 * InvalidUserInputException is an object which extends Exceptions 
 * to tell the program when it failed to recieve  a proper input from the user. 
 * 
 * @author Tiago Redaelli and Alexander Nordlund
 * @version 1.2
 * @since 1.0
 */

/** 
 * Creates a generic user input exception failure. 
 * */
class InvalidUserInputException extends Exception {
    public InvalidUserInputException() {
        super("Invalid user input.");
    }
    
    /** Creates a specific user input exception failure.
     * @param input is the text recieved  from the user. 
    * */
    public InvalidUserInputException(String input) {
        super("Invalid user input: " + input);
    }
}

