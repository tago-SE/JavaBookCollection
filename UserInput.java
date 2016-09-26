package lab_3b_1;
import java.util.Scanner;

/**
 * UserInput is an object which contains static methods to recieve user input.
 * 
 * @author Tiago Redaelli and Alexander Nordlund
 * @version 1.2
 * @since 1.0
 */

public class UserInput {
    
    /** String to Integer parse.
     * @param text the text which is going to be converted 
     * @return Integer.parseInt(text) or null 
     * */
    private static Integer tryParseInteger(String text) {
        try {
          return Integer.parseInt(text);
        } catch (NumberFormatException e) {
          return null;
        } 
    }
    
    /** String to Double parse.
     * @param text the text which is going to be converted 
     * @return Double.parseDouble(text) or null
     * */
    private static Double tryParseDouble(String text) {
        try {
          return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return null;
        } 
    }
    
    /** Tries to get an integer from the user. 
     * @return Integer.parseInt(line)
     * */
    public static int getInt() throws InvalidUserInputException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if (UserInput.tryParseInteger(line) == null) {
            System.out.println("Invalid entry.");
            throw new InvalidUserInputException(line);
        }
        return Integer.parseInt(line); 
    }
    
    /** Gets a String from the user.
     * @return scan.nextLine()
     * */
    public static String getStr() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    /** Tries to get a double from the user. 
     * @return Double.parseDouble(line)
     * */ 
    public static double getDouble() throws InvalidUserInputException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if (UserInput.tryParseDouble(line) == null) {
            throw new InvalidUserInputException(line);
        }
        return Double.parseDouble(line); 
    }   
    
    /** Prompts the user with a question and gets a String from the user. 
     * @param quesion, a question for the user to answer. 
     * @return UserInput.getStr()
     * */
    public static String askForStr(String question) {
        System.out.print(question);
        return UserInput.getStr();
    }
    
    
    /** Prompts the user with a question and tries to get a integer from the user.
     * @param quesion, a question for the user to answer. 
     * @return UserInput.askForInt(question)
     * */
    public static int askForInt(String question) {
        System.out.print(question);    
        try {
            return UserInput.getInt();
        } catch (InvalidUserInputException ex) {
            System.out.println("Invalid entry.");
            return UserInput.askForInt(question);
        }
    }

    /** Prompts the user with a question and tries to get a double from the user. 
     * @param quesion, a question for the user to answer. 
     * @return UserInput.askForDouble(question)
     * */
    public static double askForDouble(String question){
        System.out.print(question);
        try {
            return UserInput.getDouble();
        } catch (InvalidUserInputException ex) {
            System.out.println("Invalid entry.");
            return UserInput.askForDouble(question);
        }
    }          
}
