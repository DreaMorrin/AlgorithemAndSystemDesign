package test;

import main.Practice.UrlValidator;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UrlValidatorTest {
    @Test
    public void testCase1() {
        String url = "https://google.com/";
        assertTrue(UrlValidator.isValid(url));
    }

    @Test
    public void testCase2() {
        String url = "http://google.com";
        assertTrue(UrlValidator.isValid(url));
    }

    @Test
    public void testCase3() {
        String url = "http://www.google.com/";
        assertTrue(UrlValidator.isValid(url));
    }

    @Test
    public void testCase4() {
        String url = "http://ww.google.com/";
        assertTrue(UrlValidator.isValid(url));
    }

    @Test
    public void testCase5() {
        String url = "http:// .google.com/";
        assertFalse(UrlValidator.isValid(url));
    }

    @Test
    public void testCase6() {
        String url = "www.google.com/";
        assertFalse(UrlValidator.isValid(url));
    }
}
