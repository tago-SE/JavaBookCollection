package lab_3b_1;

class InvalidUserInputException extends Exception {
    public InvalidUserInputException() {
        super("Invalid user input.");
    }
    
    public InvalidUserInputException(String input) {
        super("Invalid user input: " + input);
    }
}
