package arrays_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseStringTest {

    @Test
    @DisplayName("reverseString")
    void reverseString() {
        char[] s = "hello".toCharArray();
        // given
        // expected
        Assertions.assertThat(ReverseString.reverseString(s)).isEqualTo("olleh".toCharArray());
    }
}