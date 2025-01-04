package arrays_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    @DisplayName("two sum = target")
    void twoSumTest() {
        // expected
        Assertions.assertThat(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)).isEqualTo(new int[]{0, 1});
        Assertions.assertThat(new TwoSum().twoSum(new int[]{-1, -2, -3, -4, -5}, -8)).isEqualTo(new int[]{2, 4});
    }
}