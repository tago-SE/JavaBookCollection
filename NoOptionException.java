package lab_3b_1;

public class NoOptionException extends Exception {
    public NoOptionException() {
        super("Failed to find a user option.");
    }
}
