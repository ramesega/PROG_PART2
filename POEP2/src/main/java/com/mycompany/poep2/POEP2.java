/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poep2;
import javax.swing.*;


/**
 *
 * @author RC_Student_lab
 */
public class POEP2 {
    public String UserName;
    public String Password;
    public int CellPhone;

     // Method to display the landing page with options to Register or Exit
    public void landingPage() {
        String[] options = {"Register", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Welcome! Kindly select an option:",
                "Welcome to the Registration Page",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        // If user selects Register
        if (choice == 0) {
            RegisterUser();
        } else {
            // Exit the application
            JOptionPane.showMessageDialog(null, "Exiting application...");
            System.exit(0);
        }
    }

    // Method to validate username format
    public boolean CheckUserName() {
        while (true) {
            // Prompt user for username input
            String input = JOptionPane.showInputDialog(null, "Enter username:\n(Must contain an underscore and < 5 chars)");
            if (input == null) System.exit(0);  // Handle cancel input

            UserName = input.trim();
            // Check if username contains an underscore and is less than 5 characters
            if (UserName.contains("_") && UserName.length() < 5) {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username format.");
            }
        }
    }

    // Method to validate password complexity
    public boolean checkPassword() {
        while (true) {
            // Prompt user for password input
            String input = JOptionPane.showInputDialog(null, "Enter password:\n(<8 chars, upper, digit, special)");
            if (input == null) System.exit(0);  // Handle cancel input

            if (input.length() >= 8) {
                JOptionPane.showMessageDialog(null, "Password too long.");
                continue;
            }

            Password = input;
            boolean hasUpper = false, hasDigit = false, hasSpecial = false;
            String specials = "~!@#$%^&*()_+<>?/{}[];:'\",.";

            // Check for required characters in password
            for (char c : Password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                if (Character.isDigit(c)) hasDigit = true;
                if (specials.contains(String.valueOf(c))) hasSpecial = true;
            }

            // If all conditions are met, accept password
            if (hasUpper && hasDigit && hasSpecial) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Password invalid.");
            }
        }
    }

    // Method to validate South African cellphone number format
    public boolean validateCellphone() {
        while (true) {
            // Prompt user for cellphone number
            String input = JOptionPane.showInputDialog(null, "Enter cellphone number starting with +27:");
            if (input == null) System.exit(0);  // Handle cancel input

            // Check format: starts with +27, has 12 characters, and remaining are digits
            if (input.startsWith("+27") && input.length() == 12 && input.substring(1).matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Cellphone captured");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid cellphone number.");
            }
        }
    }

    // Method to handle full user registration
    public void RegisterUser() {
        // Run all validation methods; exit if any return false
        if (!CheckUserName() || !checkPassword() || !validateCellphone()) return;

        JOptionPane.showMessageDialog(null, "Registration Successful!");

        // Create a login instance and attempt login
        LoginP2 login = new LoginP2(UserName, Password);
        boolean loginUser = login.loginUser();
        JOptionPane.showMessageDialog(null, login.returnLoginStatus());

        // If login is successful, proceed to main menu
        if (loginUser) {
            JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");
            mainMenu();
        }
    }

    public void mainMenu() {
    int sent = 0;
    int maxMessages = 0;
    boolean messageLimitSet = false;

    while (true) {
        String[] options = {"Send Message", "Show Recent Messages", "Quit"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Main Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Ask how many messages the user wants to send if not set yet
            if (!messageLimitSet) {
                maxMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
                messageLimitSet = true;
            }

            // If message limit is reached, block sending
            if (sent >= maxMessages) {
                JOptionPane.showMessageDialog(null, "Message limit reached.");
                continue;
            }

            // Validate recipient input
            String recipient;
            do {
                recipient = JOptionPane.showInputDialog("Enter recipient number (+27):");
                if (recipient == null || recipient.trim().isEmpty() || !recipient.startsWith("+27")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid recipient number starting with +27.");
                }
            } while (recipient == null || recipient.trim().isEmpty() || !recipient.startsWith("+27"));

            // Get message text
                        String msgText;
            do {
                msgText = JOptionPane.showInputDialog("Enter message (max 250 chars):");
                if (msgText == null || msgText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Message cannot be empty.");
                } else if (msgText.length() > 250) {
                    JOptionPane.showMessageDialog(null, "Please enter a message under 250 characters.");
                }
            } while (msgText == null || msgText.trim().isEmpty() || msgText.length() > 250);


            // Create message object and show result
            MessageP2 message = new MessageP2(recipient, msgText);
            String result = message.sentMessage();
            JOptionPane.showMessageDialog(null, result);
            sent++;

        } else if (choice == 1) {
            // Placeholder for showing recent messages
            JOptionPane.showMessageDialog(null, "Coming Soon.");
        } else if (choice == 2) {
            // Display total messages sent and exit loop
            JOptionPane.showMessageDialog(null, "Total messages sent: " + MessageP2.returnTotalMessages());
            break;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice.");
        }
    }

    // Final exit message
    JOptionPane.showMessageDialog(null, "Thank you, Goodbye");
}

    // Entry point of the program
    public static void main(String[] args) {
        POEP2 app = new POEP2();
        app.landingPage();
    }
}