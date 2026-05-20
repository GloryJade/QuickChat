package quickchat;

public class Message {
    private String messageId;
    private final String recipientCell;
    private final String messageText;
    private String messageHash;
    private int counterIndex;
    private String status;

    public Message(String messageId, String recipientCell, String messageText, int counterIndex) {
        this.messageId = messageId;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.counterIndex = counterIndex;
        this.status = "Disregarded";
        this.messageHash = ""; 
    }

    public boolean checkMessageID() {
        if (this.messageId == null) return false;
        return this.messageId.length() <= 10;
    }

    public String checkRecipientCell() {
        if (this.recipientCell == null || this.recipientCell.trim().isEmpty()) {
            return "Invalid: Empty Number";
        }
        String numericSanitized = this.recipientCell.replace("+", "").trim();
        if (this.recipientCell.startsWith("+") || this.recipientCell.startsWith("0")) {
            if (numericSanitized.length() <= 11) {
                return "Valid Cell Structure";
            }
        }
        return "Invalid Cell Structure";
    }

    public String createMessageHash() {
        if (this.messageId == null || this.messageId.length() < 2) {
            this.messageId = "0000000000";
        }
        if (this.messageText == null || this.messageText.trim().isEmpty()) {
            return "00:0:EMPTY";
        }
        String prefixId = this.messageId.substring(0, 2);
        String cleanText = this.messageText.trim().replaceAll("\\s+", " ");
        String[] words = cleanText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String combinedWords = (firstWord + lastWord).replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        
        this.messageHash = prefixId + ":" + this.counterIndex + ":" + combinedWords;
        return this.messageHash;
    }

    public String validateMessageLength() {
        if (this.messageText != null && this.messageText.length() <= 250) {
            return "Message sent";
        } else {
            return "Please enter a message of less than 250 characters.";
        }
    }

    public String getMessageId() { return messageId; }
    public String getRecipientCell() { return recipientCell; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public int getCounterIndex() { return counterIndex; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}