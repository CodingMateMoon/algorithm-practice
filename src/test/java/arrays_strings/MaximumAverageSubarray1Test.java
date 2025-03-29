package arrays_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumAverageSubarray1Test {

    @Test
    void findMaxAverage() {
        MaximumAverageSubarray1 solution = new MaximumAverageSubarray1();
        Assertions.assertThat(solution.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)).isEqualTo(12.75);
    }
}