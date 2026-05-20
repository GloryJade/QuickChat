package quickchat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MessageManager manager = new MessageManager();
        
        System.out.println("Welcome to QuickChat.");
        
        OUTER:
        while (true) {
            System.out.println("\nMenu:\n1) Send Messages\n2) Show recently sent messages\n3) Quit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 3:
                    System.out.println("Total messages sent: " + manager.returnTotalMessages());
                    break OUTER;
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                case 1:
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
                    }   System.out.println(manager.printMessages());
                    break;
                default:
                    break;
            }
        }
    }
}