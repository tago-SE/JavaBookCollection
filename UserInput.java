package lab_3b_1;
import java.util.Scanner;

public class UserInput {
    
    private static Integer tryParseInteger(String text) {
        try {
          return Integer.parseInt(text);
        } catch (NumberFormatException e) {
          return null;
        } 
    }
    
    private static Double tryParseDouble(String line) {
        try {
          return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return null;
        } 
    }
    
    public static int getInt() throws InvalidUserInputException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if (UserInput.tryParseInteger(line) == null) {
            System.out.println("Invalid entry.");
            throw new InvalidUserInputException(line);
        }
        return Integer.parseInt(line); 
    }
    
    public static String getStr() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    
    public static String askForStr(String question) {
        System.out.print(question);
        return UserInput.getStr();
    }
    
    public static double getDouble() throws InvalidUserInputException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if (UserInput.tryParseDouble(line) == null) {
            throw new InvalidUserInputException(line);
        }
        return Double.parseDouble(line); 
    }   
    
    public static int askForInt(String question) {
        System.out.print(question);    
        try {
            return UserInput.getInt();
        } catch (InvalidUserInputException ex) {
            System.out.println("Invalid entry.");
            return UserInput.askForInt(question);
        }
    }
     
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


