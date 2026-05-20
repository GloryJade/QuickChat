package quickchat;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {
    private final List<Message> messageInventory = new ArrayList<>();
    private int totalSentCount = 0;

    public String SentMessage(Message msg, int actionOption) {
        switch (actionOption) {
            case 1 -> {
                msg.setStatus("Sent");
                totalSentCount++;
                messageInventory.add(msg);
                return "Message successfully sent";
            }
            case 3 -> {
                msg.setStatus("Stored");
                messageInventory.add(msg);
                return "Message successfully stored";
            }
            default -> {
                msg.setStatus("Disregarded");
                return "Message Disregarded";
            }
        }
    }

    public String printMessages() {
        if (messageInventory.isEmpty()) return "No active message logs found.";
        StringBuilder sb = new StringBuilder("\n===================================\n       QUICKCHAT SYSTEM REPORT     \n===================================\n");
        for (Message m : messageInventory) {
            sb.append("Message ID: ").append(m.getMessageId()).append("\n")
              .append("Message Hash: ").append(m.getMessageHash()).append("\n")
              .append("Recipient: ").append(m.getRecipientCell()).append("\n")
              .append("Message: \"").append(m.getMessageText()).append("\"\n")
              .append("Status: ").append(m.getStatus()).append("\n-----------------------------------\n");
        }
        return sb.toString();
    }

    public int returnTotalMessages() { return this.totalSentCount; }
}
