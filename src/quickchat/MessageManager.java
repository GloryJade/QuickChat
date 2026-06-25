package quickchat;

import java.util.ArrayList;

public class MessageManager {
    private ArrayList<Message> messageHistory = new ArrayList<>();
    private ArrayList<String> messageStatuses = new ArrayList<>();
    private int totalMessagesCount = 0;

    public String SentMessage(Message msg, int action) {
        totalMessagesCount++;
        String status;
        
        if (action == 1) {
            status = "SENT";
        } else if (action == 2) {
            status = "DISREGARDED";
        } else if (action == 3) {
            status = "STORED";
        } else {
            status = "UNKNOWN";
        }
        
        messageHistory.add(msg);
        messageStatuses.add(status);
        
        return "Message ID " + msg.getMessageId() + " status set to: " + status;
    }

    public int returnTotalMessages() {
        return totalMessagesCount;
    }

    public String searchMessageById(String id) {
        for (int i = 0; i < messageHistory.size(); i++) {
            if (messageHistory.get(i).getMessageId().equalsIgnoreCase(id)) {
                Message m = messageHistory.get(i);
                return "\n[FOUND] ID: " + m.getMessageId() 
                     + "\nRecipient: " + m.getRecipientNumber() 
                     + "\nStatus: " + messageStatuses.get(i);
            }
        }
        return "\nMessage ID '" + id + "' not found.";
    }

    public String printMessages() {
        if (messageHistory.isEmpty()) {
            return "\nNo messages processed in this session yet.";
        }
        
        StringBuilder report = new StringBuilder();
        report.append("\n=========================================\n");
        report.append("     QUICKCHAT FINAL STATUS REPORT       \n");
        report.append("=========================================\n");
        for (int i = 0; i < messageHistory.size(); i++) {
            Message m = messageHistory.get(i);
            report.append("Msg #").append(i + 1)
                  .append(" -> ID: ").append(m.getMessageId())
                  .append(" | To: ").append(m.getRecipientNumber())
                  .append(" | Status: ").append(messageStatuses.get(i)).append("\n");
        }
        return report.toString();
    }
}