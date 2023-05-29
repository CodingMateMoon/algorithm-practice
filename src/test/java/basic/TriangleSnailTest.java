package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleSnailTest {
    TriangleSnail solution = new TriangleSnail();
    //4->   [1,2,9,3,10,8,4,5,6,7]
    //5->	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
    //6->	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
    @Test
    @DisplayName("삼각달팽이")
    void triangleSnail() {
        // given
        int[] result = solution.solution(4);
        // expected
        int[] expected = {1, 2, 9, 3, 10, 8, 4, 5, 6, 7};

        Assertions.assertThat(expected).isEqualTo(result);
    }
}