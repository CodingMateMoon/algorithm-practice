package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberSumTest {

    @Test
    @DisplayName("test")
    void getNumberSumTest() {
        // given
        int[] arr = {1, 2, 3, 4, 5};
        // expected
        Assertions.assertThat(NumberSum.getNumberSum(arr)).isEqualTo(15);

        char lower = 'e';
        char upper = (char) (lower + ('a' - 'A'));
        char answer = (char) (lower - ('a' - 'A'));
        System.out.println("upper : " + upper + " : " + answer);
    }
}