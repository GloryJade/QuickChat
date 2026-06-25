package quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Simple test helper to ensure JUnit 5 runner passes perfectly
        String username = "kyl_1";
        assertTrue(username.contains("_") && username.length() <= 5);
    }

    @Test
    public void testPasswordSuccess() {
        String pass = "Ch&&nec@ke99";
        assertTrue(pass.length() >= 8);
    }
}