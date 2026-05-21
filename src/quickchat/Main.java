package quickchat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // ==========================================
        // PART 1: ACCOUNT REGISTRATION
        // ==========================================
        System.out.println("--- WELCOME TO THE SYSTEM ---");
        System.out.println("Please register your account below:\n");
        
        System.out.print("Enter username: ");
        String registeredUser = input.nextLine();
        System.out.println("Username successfully captured.");
        
        System.out.print("Enter password: ");
        String registeredPass = input.nextLine();
        System.out.println("Password successfully captured.");
        
        System.out.print("Enter South African cell phone number: ");
        String registeredCell = input.nextLine();
        System.out.println("Cell phone number successfully added.");
        
        // ==========================================
        // PART 1 & 2: LOGIN AUTHENTICATION
        // ==========================================
        System.out.println("\n---------------------------------");
        System.out.println("--- LOGIN TO YOUR ACCOUNT ---");
        System.out.println("---------------------------------");
        
        System.out.print("Enter user name: ");
        String loginUser = input.nextLine();
        
        System.out.print("Enter password: ");
        String loginPass = input.nextLine();
        
        // Verifies the user inputs match the registered credentials
        if (loginUser.equals(registeredUser) && loginPass.equals(registeredPass)) {
            System.out.println("\nWelcome " + loginUser + ", it is great to see you");
            System.out.println("Login Successful");
            
            // Unlocks Part 2 features
            runQuickChatSystem(input);
        } else {
            System.out.println("\nUsername or password incorrect, please try again.");
            System.out.println("Login Failed");
        }
        
        input.close();
    }

    // ==========================================
    // PART 2: QUICKCHAT SYSTEM MENU
    // ==========================================
    public static void runQuickChatSystem(Scanner input) {
        MessageManager manager = new MessageManager();
        
        System.out.println("\nWelcome to QuickChat");
        
        while (true) {
            System.out.println("\nMenu:\n1) Send Messages\n2) Show recently sent messages\n3) Quit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); 
            
            if (choice == 3) {
                System.out.println("Total messages sent: " + manager.returnTotalMessages());
                break;
            } else if (choice == 2) {
                System.out.println("Coming Soon.");
            } else if (choice == 1) {
                System.out.print("How many messages would you like to send? ");
                int batchSize = input.nextInt();
                input.nextLine();
                
                for (int i = 0; i < batchSize; i++) {
                    System.out.println("\n--- Sending Message " + (i + 1) + " of " + batchSize + " ---");
                    
                    System.out.print("Enter phone number: ");
                    String cell = input.nextLine();
                    System.out.print("Enter message text: ");
                    String text = input.nextLine();
                    
                    String mockId = "92837461" + i;
                    Message msg = new Message(mockId, cell, text, i);
                    
                    System.out.println(msg.validateMessageLength());
                    System.out.println("Structure: " + msg.checkRecipientCell());
                    
                    System.out.println("\nAction Menu:\n1) Send\n2) Disregard\n3) Store");
                    System.out.print("Choose action: ");
                    int action = input.nextInt();
                    input.nextLine();
                    
                    System.out.println(manager.SentMessage(msg, action));
                }
                System.out.println(manager.printMessages());
            }
        }
    } 
}