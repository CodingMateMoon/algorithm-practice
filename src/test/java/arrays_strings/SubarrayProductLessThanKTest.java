package arrays_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubarrayProductLessThanKTest {

    @Test
    @DisplayName("numSubarrayProductLessThanK")
    void numSubarrayProductLessThanK() {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
        Assertions.assertThat(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)).isEqualTo(8);
    }
}