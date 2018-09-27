import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /* You must use this palindrome, and not instantiate
    new Palindromes, or the autograder might be upset.*/

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){

        String word1 = "racecar";

        String word2 = "share";

        String word3 = "a";

        String word4 = "";

        String word5 = "asdsap";

        assertEquals(palindrome.isPalindrome(word1), true);
        assertEquals(palindrome.isPalindrome(word2), false);
        assertEquals(palindrome.isPalindrome(word3), true);
        assertEquals(palindrome.isPalindrome(word4), true);
        assertEquals(palindrome.isPalindrome(word5), false);

    }

    @Test
    public void testIsPalindromeOverload(){

        OffByOne p = new OffByOne();

        assertEquals(palindrome.isPalindrome("flake", p), true);
        assertEquals(palindrome.isPalindrome("johnson", p), false);
        assertEquals(palindrome.isPalindrome("p", p), true);


    }


}
