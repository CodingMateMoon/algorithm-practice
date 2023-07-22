package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseNumberTest {

    @Test
    @DisplayName("reverse Number")
    void reverseNumber() {
        // given
        int[] result = ReverseNumber.solution(12345L);
        // expected
        Assertions.assertThat(result).isEqualTo(new int[]{5, 4, 3, 2, 1});
    }
}