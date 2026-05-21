package quickchat;

import org.junit.Test;
import org.junit.Assert.*; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message validMsg = new Message("1234567890", "+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        assertEquals("Message sent", validMsg.validateMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {
        StringBuilder tooLongText = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            tooLongText.append("This is an excessive string test layout sentence payload token. ");
        }
        Message invalidMsg = new Message("1122334455", "08575975889", tooLongText.toString(), 1);
        assertEquals("Please enter a message of less than 250 characters.", invalidMsg.validateMessageLength());
    }

    @Test
    public void testCheckMessageIDValid() {
        Message testMsg = new Message("8929921204", "+27715693002", "Hello World", 0);
        assertTrue(testMsg.checkMessageID());
    }

    @Test
    public void testCreateMessageHashFormulaVerification() {
        Message msg = new Message("9283746152", "+27715693002", "Hi Mike, dinner", 2);
        String finalHash = msg.createMessageHash();
        assertEquals("92:2:HIDINNER", finalHash);
    }
}
