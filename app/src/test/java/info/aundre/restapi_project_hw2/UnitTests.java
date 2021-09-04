package info.aundre.restapi_project_hw2;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    private User getUser() {
        return new User("TestUsername", "TestPassword", 0);
    }

    @Test
    public void getUserIdTest() {
        assertEquals(0, getUser().getId());
    }

    @Test
    public void getUsernameTest() {
        assertEquals("TestUsername", getUser().getUsername());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("TestPassword", getUser().getPassword());
    }

    @Test
    public void validateUserCredentials() {
        String username = "Bret";
        assertEquals(1 , MainActivity.validate(username, "bretrock"));
    }

    @Test
    public void validateUserCredentialsErr() {
        assertEquals(-1, MainActivity.validate("Breeeeeeet", "WRong"));
    }
}