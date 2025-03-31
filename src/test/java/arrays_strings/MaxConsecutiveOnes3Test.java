package arrays_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class MaxConsecutiveOnes3Test {

    @Test
    @DisplayName("longestOnes")
    void longestOnes() {
        // given
        MaxConsecutiveOnes3 solution = new MaxConsecutiveOnes3();
        // expected
        Assertions.assertThat(solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)).isEqualTo(6);
    }

}