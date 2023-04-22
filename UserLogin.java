import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogin {

    // Database to store user credentials
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password, idCard;
        
        // Sign-up process
        System.out.println("Welcome to User Login System");
        System.out.println("Please enter your desired username and password to sign up");
        
        // Validate username
        do {
            System.out.print("Username: ");
            username = scanner.nextLine();
        } while (!isValidUsername(username));
        
        // Validate password
        do {
            System.out.print("Password (must have at least 6 characters with Uppercase Letter, Lowercase Letter and Number): ");
            password = scanner.nextLine();
        } while (!isValidPassword(password));
        
        // Validate Thai ID card
        do {
            System.out.print("Thai ID card (13 digits): ");
            idCard = scanner.nextLine();
        } while (!isValidThaiID(idCard));
        
        // Add user to database
        userDatabase.put(username, password);
        System.out.println("Sign up successful!");
        
        // Login process
        System.out.println("\nPlease enter your credentials to login");
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        
        // Check if user exists in database and if password matches
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
        } 
        else {
            System.out.println("Invalid username or password. Please try again.");
        }
        
        scanner.close();
    }
    
    // Method to validate username
    public static boolean isValidUsername(String username) {
        return true;
    }
    
    // Method to validate password
    public static boolean isValidPassword(String password) {
    // Check length
        if (password.length() < 6) {
            System.out.println("Password must be 6 characters");
            return false;
        }
    
    // Check for uppercase letters, lowercase letters, and numbers
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
    
        for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);
      
        if (Character.isUpperCase(c)) {
            hasUppercase = true;
        } 
        else if (Character.isLowerCase(c)) {
            hasLowercase = true;
        } 
        else if (Character.isDigit(c)) {
            hasNumber = true;
        }
      
        if (hasUppercase && hasLowercase && hasNumber) {
            return true;
        }
        }
        System.out.println("Password must be uppercase letter, lowercase letter, number");
        return false;
    }
    
    // Method to validate Thai ID card
    public static boolean isValidThaiID(String idCard) {
        if (idCard.length() != 13) {
            System.out.println("Thai ID card must be 13 digits.");
            return false;
        }
        try {
            Long.parseLong(idCard);
        } catch (NumberFormatException e) {
            System.out.println("Thai ID card must be a number.");
            return false;
        }
        return true;
    }

}

