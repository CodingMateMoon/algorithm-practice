package arrays_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SquaresOfaSortedArrayTest {

    @Test
    @DisplayName("Squares of a Sorted Array")
    void sortTest() {
        // given
        SquaresOfaSortedArray sol = new SquaresOfaSortedArray();
        // expected
        Assertions.assertThat(sol.sortedSquares(new int[]{-4, -1, 0, 3, 10})).isEqualTo(new int[]{0,1,9,16,100});
    }
}