import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("olleh", utils.reverse("hello"));
        assertEquals("", utils.reverse(""));
        assertEquals("54321", utils.reverse("12345"));
    }

    @Test
    void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("radar"));
        assertFalse(utils.isPalindrome("hello"));
        assertTrue(utils.isPalindrome(""));
        assertTrue(utils.isPalindrome("a"));
    }

    @Test
    void testConcatenate() {
        StringUtils utils = new StringUtils();
        assertEquals("HelloWorld", utils.concatenate("Hello", "World"));
        assertEquals("123456", utils.concatenate("123", "456"));
        assertEquals("test", utils.concatenate("test", ""));
        assertEquals("concat", utils.concatenate("", "concat"));
    }

    @Test
    void testCountOccurrences() {
        StringUtils utils = new StringUtils();
        assertEquals(2, utils.countOccurrences("hello", 'l'));
        assertEquals(3, utils.countOccurrences("hello", 'o'));
        assertEquals(0, utils.countOccurrences("world", 'z'));
        assertEquals(0, utils.countOccurrences("", 'a'));
    }
}
