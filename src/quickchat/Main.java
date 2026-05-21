package quickchat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println("--- WELCOME TO THE SYSTEM ---");
        System.out.print("Enter user name: ");
        String user = console.nextLine();
        System.out.print("Enter password: ");
        String pass = console.nextLine();
        
        // This is your exact login verification logic from Part 1!
        if (user.equals("jade_1") && pass.equals("Rainbow-1")) {
            System.out.println("Welcome Jade Glory, it is great to see you again");
            
            // Login successful! Now we seamlessly jump straight into your Part 2 QuickChat Menu
            runQuickChatSystem(console);
            
        } else {
            System.out.println("Username or password incorrect, please try again");
        }
    }

    // Moving your Part 2 QuickChat logic down here keeps the code super organized and clean
    public static void runQuickChatSystem(Scanner input) {
        MessageManager manager = new MessageManager();
        System.out.println("\nWelcome to QuickChat.");
        
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
                System.out.print("Enter batch size: ");
                int batchSize = input.nextInt();
                input.nextLine();
                
                for (int i = 0; i < batchSize; i++) {
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
}s