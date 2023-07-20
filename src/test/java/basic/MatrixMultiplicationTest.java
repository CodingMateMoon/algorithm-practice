package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixMultiplicationTest {
    
    @Test
    @DisplayName("multifly matrices")
    void multify_matrices() {
        // given
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        // expected
        assertThat(MatrixMultiplication.solution(arr1, arr2)).isEqualTo(new int[][]{{15, 15}, {15, 15}, {15,15}});
    }

    @Test
    @DisplayName("multifly matrices2")
    void multify_matrices2() {
        // given
        int[][] arr1 = {{2, 3, 2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = {{5,4,3}, {2,4,1}, {3,1,1}};

        // expected
        assertThat(MatrixMultiplication.solution(arr1, arr2)).isEqualTo(new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}});
    }
}
