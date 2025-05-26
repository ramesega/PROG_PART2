/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poep2;

import javax.swing.*;

/**
 *
 * @author RC_Student_lab
 */

public class LoginP2 {
    // Stores the username provided during registration
    private String storedUsername;

    // Stores the password provided during registration
    private String storedPassword;

    // Tracks the login status of the user
    private boolean isLoggedIn = false;

    // Constructor initializes stored credentials
    public LoginP2(String username, String password) {
        this.storedUsername = username;
        this.storedPassword = password;
    }

    // Handles user login process
    public boolean loginUser() {
        while (true) {
            // Prompt user to enter username
            String loginUser = JOptionPane.showInputDialog(null, "Enter Username:");
            if (loginUser == null) return false; // Exit if user cancels

            // Check if username matches stored username
            if (!loginUser.equals(storedUsername)) {
                JOptionPane.showMessageDialog(null, "Incorrect username.");
                continue; // Loop again if incorrect
            }

            // Prompt user to enter password
            String loginPass = JOptionPane.showInputDialog(null, "Enter Password:");
            if (loginPass == null) return false; // Exit if user cancels

            // Check if password matches stored password
            if (!loginPass.equals(storedPassword)) {
                JOptionPane.showMessageDialog(null, "Incorrect password.");
                continue; // Loop again if incorrect
            }

            // If both username and password match, set login status and exit loop
            isLoggedIn = true;
            return true;
        }
    }

    // Returns the login status message
    public String returnLoginStatus() {
        return isLoggedIn ? "Login successful!" : "Login failed!";
    }
}