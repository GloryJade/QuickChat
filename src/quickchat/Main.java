package quickchat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // ===================================================
        // STEP 1 & 2: ACCOUNT REGISTRATION (PART 1 ALIGNED)
        // ===================================================
        System.out.println("--- QUICKCHAT POE ACCOUNT SYSTEM ---");
        System.out.println("Please register your account credentials:\n");
        
        System.out.print("Enter username: ");
        String registeredUser = input.nextLine();
        System.out.println("Username successfully captured.");
        
        System.out.print("Enter password: ");
        String registeredPass = input.nextLine();
        System.out.println("Password successfully captured.");
        
        System.out.print("Enter South African phone number: ");
        String registeredCell = input.nextLine();
        System.out.println("Cell phone number successfully added.");
        
        // ===================================================
        // STEP 3: LOGIN AUTHENTICATION ROUTINE
        // ===================================================
        System.out.println("\n---------------------------------");
        System.out.println("--- LOGIN SECURE ENTRY PORTAL ---");
        System.out.println("---------------------------------");
        
        System.out.print("Enter username to log in: ");
        String loginUser = input.nextLine();
        System.out.print("Enter password to log in: ");
        String loginPass = input.nextLine();
        
        if (loginUser.equals(registeredUser) && loginPass.equals(registeredPass)) {
            System.out.println("\nWelcome back " + loginUser + ", it is great to see you.");
            System.out.println("Login Successful");
            
            // Seamlessly transfer into the message handling engine
            runQuickChatApplicationLoop(input);
        } else {
            System.out.println("\nUsername or password incorrect. Login Failed.");
        }
        
        input.close();
    }

    // ===================================================
    // STEP 4, 5 & 6: CORE BATCH RUNNER & SUMMARY REVIEWS
    // ===================================================
    public static void runQuickChatApplicationLoop(Scanner input) {
        MessageManager manager = new MessageManager();
        System.out.println("\n=================================");
        System.out.println("Welcome to the QuickChat System");
        System.out.println("=================================");
        
        while (true) {
            System.out.println("\nMain Operations Menu:");
            System.out.println("1) Send Batch Messages");
            System.out.println("2) Show Recently Sent Messages (Report Summary)");
            System.out.println("3) Search Session Message history by ID");
            System.out.println("4) Exit Program");
            System.out.print("Select choice number: ");
            
            int choice = input.nextInt();
            input.nextLine(); // CRITICAL FIX: Clears scanner buffer so subsequent loops do not crash
            
            if (choice == 4) {
                System.out.println("\nTotal session messages archived: " + manager.returnTotalMessages());
                System.out.println("Exiting application suite. Goodbye!");
                break;
            } 
            else if (choice == 3) {
                // STEP 6: ARRAY SEARCH COMPONENT
                System.out.print("\nEnter custom message tracking ID to search: ");
                String searchId = input.nextLine();
                System.out.println(manager.searchMessageById(searchId));
            } 
            else if (choice == 2) {
                // STEP 5: FINAL SYSTEM POE REPORT SUMMARY 
                System.out.println(manager.printMessages());
            } 
            else if (choice == 1) {
                System.out.print("\nHow many distinct messages do you want to create in this batch? ");
                int batchSize = input.nextInt();
                input.nextLine(); // Clear scanner buffer again
                
                for (int i = 0; i < batchSize; i++) {
                    System.out.println("\n--- Writing Entry " + (i + 1) + " of " + batchSize + " ---");
                    
                    System.out.print("Enter recipient phone number: ");
                    String cell = input.nextLine();
                    
                    System.out.print("Enter textual message content: ");
                    String text = input.nextLine();
                    
                    System.out.print("Assign a unique Custom Tracking ID (e.g. MSG_01): ");
                    String customId = input.nextLine();
                    
                    // Bundle variables into our Object context
                    Message msg = new Message(customId, cell, text, i);
                    
                    // Display system structural logic status rules
                    System.out.println("Length check status: " + msg.validateMessageLength());
                    System.out.println("Phone metadata classification: " + msg.checkRecipientCell());
                    
                    // Action Routing Execution Menu
                    System.out.println("Action Router options:\n1) Mark as Sent\n2) Mark as Disregarded\n3) Mark as Stored");
                    System.out.print("Select action code: ");
                    int actionCode = input.nextInt();
                    input.nextLine(); // Clear scanner buffer
                    
                    // Log to the storage array list instantly
                    System.out.println(manager.SentMessage(msg, actionCode));
                }
            }
        }
    }
}