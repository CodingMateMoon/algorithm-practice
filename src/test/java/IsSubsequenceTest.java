import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IsSubsequenceTest {

    @Test
    @DisplayName("IsSubsequence")
    void IsSubsequence() {
        IsSubsequence isSubsequence = new IsSubsequence();
        Assertions.assertTrue(isSubsequence.isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence.isSubsequence("axc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence.isSubsequence("aaaaaa", "bbaaaa"));
    }
}