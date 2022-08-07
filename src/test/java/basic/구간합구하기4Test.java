package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 구간합구하기4Test {
    @Test
    void 구간의합_구하기() {
        int[] numberArray = {5, 4, 3, 2, 1};
        int[] numberSumArray = new int[numberArray.length];
        for (int i = 0; i < numberArray.length; i++) {
            if (i == 0) {
                numberSumArray[i] = numberArray[i];
                continue;
            }
            numberSumArray[i] = numberSumArray[i - 1] + numberArray[i];
        }

        assertThat(IntervalSumUtil.getIntervalSum(numberSumArray, 0, 2)).isEqualTo(12);
        assertThat(IntervalSumUtil.getIntervalSum(numberSumArray, 1, 3)).isEqualTo(9);
        assertThat(IntervalSumUtil.getIntervalSum(numberSumArray, 4, 4)).isEqualTo(1);
    }
}
