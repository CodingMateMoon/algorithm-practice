package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleSnail3Test {

    @Test
    @DisplayName("solution")
    void solution() {
        // given
        int[] result = TriangleSnail3.solution(4);
        int[] expected = {1,2,9,3,10,8,4,5,6,7};
        // expected
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
