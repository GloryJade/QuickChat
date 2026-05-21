package quickchat;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        // Test with a message safely within the 250-character limit
        Message msg = new Message("111", "0831234567", "Hello this is a valid message length.", 0);
        String expected = "Message ready to send";
        assertEquals(expected, msg.validateMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {
        // Creates a message that deliberately exceeds 250 characters
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longText.append("a");
        }
        
        Message msg = new Message("222", "0831234567", longText.toString(), 0);
        
        // Dynamic string calculation matches exactly what the rubric requires
        int exceededBy = longText.length() - 250;
        String expected = "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
        assertEquals(expected, msg.validateMessageLength());
    }

    @Test
    public void testRecipientCellStructure() {
        // Verifies the message checkRecipientCell logic returns structural information cleanly
        Message msg = new Message("333", "0831234567", "Test message", 0);
        assertNotNull(msg.checkRecipientCell());
    }
}