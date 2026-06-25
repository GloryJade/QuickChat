package quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message("MSG01", "0831234567", "Valid text length.", 0);
        assertNotNull(msg.validateMessageLength());
    }

    @Test
    public void testRecipientCellStructure() {
        Message msg = new Message("MSG02", "0831234567", "Test payload", 0);
        assertEquals("Valid Structure", msg.checkRecipientCell());
    }
}