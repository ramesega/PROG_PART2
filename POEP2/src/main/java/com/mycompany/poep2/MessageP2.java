/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poep2;
import javax.swing.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author RC_Student_lab
 */  
public class MessageP2 {
    // Fields to store message details
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    // Tracks the number of messages created
    private static int messageCount = 0;

    // Stores all sent messages
    private static List<MessageP2> sentMessages = new ArrayList<>();

    // Constructor initializes message details and generates a hash
    public MessageP2(String recipient, String message) {
        this.messageID = generateMessageID(); // unique message ID
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash(); // generate hash for message
        messageCount++; // increment total message count
    }

    // Generates a random 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        return String.format("%010d", rand.nextInt(1_000_000_000));
    }

    // Validates recipient's cell number (must start with + and be ≤ 13 characters)
    public boolean checkRecipientCell() {
        return recipient.startsWith("+") && recipient.length() <= 13;
    }

    // Creates a message hash using ID, message count, first and last words
    public String createMessageHash() {
        String[] words = message.split(" ");
        String first = words.length > 0 ? words[0] : ""; // first word
        String last = words.length > 1 ? words[words.length - 1] : first; // last word (or first again)
        return (messageID.substring(0, 2) + ":" + messageCount + ":" + first + last).toUpperCase();
    }

    // Returns the number of messages sent
    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    // Handles user's choice on what to do with the message
    public String sentMessage() {
        String[] options = {"Send", "Disregard", "Store to JSON", "Store for Later"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action for the message:",
                "Message Options", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                // Add message to sent list
                sentMessages.add(this);
                return showMessageDetails() + "\nMessage sent!";
            case 1:
                return "Message disregarded.";
            case 2:
                storeMessageToJson(); // Save message as JSON
                return "Message stored in JSON.";
            case 3:
                return "Message stored for later.";
            default:
                return "No action taken.";
        }
    }

    // Returns a formatted string with all message details
    public String showMessageDetails() {
        return "Message ID: " + messageID +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + message;
    }

    // Saves the message in JSON format to a file
    @SuppressWarnings("unchecked")
    public void storeMessageToJson() {
        // Create a JSON object with message details
        JSONObject msgObj = new JSONObject();
        msgObj.put("MessageID", messageID);
        msgObj.put("MessageHash", messageHash);
        msgObj.put("Recipient", recipient);
        msgObj.put("Message", message);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(msgObj); // Add to JSON array

        // Write JSON array to file with a line break for each entry
        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(jsonArray.toJSONString());
            file.write(System.lineSeparator()); // for readability
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to save message to JSON file.");
        }
    }
}
   