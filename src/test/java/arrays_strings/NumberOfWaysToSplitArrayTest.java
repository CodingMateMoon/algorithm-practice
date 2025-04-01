package arrays_strings;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfWaysToSplitArrayTest {

    @Test
    void waysToSplitArray() {
        Assertions.assertThat(new NumberOfWaysToSplitArray().waysToSplitArray(new int[]{10,4,-8,7})).isEqualTo(2);
        Assertions.assertThat(new NumberOfWaysToSplitArray().waysToSplitArray(new int[]{2,3,1,0})).isEqualTo(2);
        Assertions.assertThat(new NumberOfWaysToSplitArray().waysToSplitArray(new int[]{0,0})).isEqualTo(1);
    }
}