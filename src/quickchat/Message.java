package quickchat;

public class Message {
    private String messageId;
    private String recipientNumber;
    private String messageText;
    private int messageNumber;

    // Constructor matching your assignment specs
    public Message(String messageId, String recipientNumber, String messageText, int messageNumber) {
        this.messageId = messageId;
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.messageNumber = messageNumber;
    }

    public String getMessageId() { return messageId; }
    public String getRecipientNumber() { return recipientNumber; }
    public String getMessageText() { return messageText; }
    public int getMessageNumber() { return messageNumber; }

    // Enforces the 250 character boundary required for full marks
    public String validateMessageLength() {
        if (this.messageText.length() <= 250) {
            return "Message ready to send";
        } else {
            int exceededBy = this.messageText.length() - 250;
            return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
        }
    }

    // Standard structural fallback validation
    public String checkRecipientCell() {
        if (this.recipientNumber.startsWith("+27") || this.recipientNumber.startsWith("0")) {
            return "Valid Structure";
        }
        return "Invalid Structure";
    }
}