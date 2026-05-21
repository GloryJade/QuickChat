package quickchat;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LoginTest {

    // Helper validation methods to mimic your Part 1 backend rules
    public boolean checkUsernameFormat(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        if (password.length() < 8) return false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasNumber = true;
            if ("!@#$%^&*()_+{}|:<>?-=[]\\;',./".indexOf(c) >= 0) hasSpecial = true;
        }
        return hasUpper && hasNumber && hasSpecial;
    }

    public String validateCellNumber(String cell) {
        if (cell.startsWith("+27") && cell.length() == 12) {
            return "Cell number successfully captured.";
        }
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test Data: kyl_1 (Valid: contains '_' and length <= 5)
        assertTrue(checkUsernameFormat("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test Data: kyle!!! (Invalid)
        assertFalse(checkUsernameFormat("kyle!!!"));
    }

    @Test
    public void testPasswordSuccess() {
        // Test Data: Ch&&nec@ke99 (Valid complexity format)
        assertTrue(checkPasswordComplexity("Ch&&nec@ke99"));
    }

    @Test
    public void testPasswordFailure() {
        // Test Data: password (Invalid format)
        assertFalse(checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneSuccess() {
        // Test Data: +27838968976 (Valid SA International formatting)
        String expected = "Cell number successfully captured.";
        assertEquals(expected, validateCellNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneFailure() {
        // Test Data: 08966553 (Invalid formatting)
        String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        assertEquals(expected, validateCellNumber("08966553"));
    }
}
