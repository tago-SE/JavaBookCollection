package lab_3b_1;

/**
 * NoOptionException is an object that takes 
 * 
 * @author Tiago Redaelli and Alexander Nordlund
 * @version 1.2
 * @since 1.0
 */

/** 
 * Creates an exception that tells the program it failed to get a valid user option. 
 * */

public class NoOptionException extends Exception {
    public NoOptionException() {
        super("Failed to find a user option.");
    }
}
