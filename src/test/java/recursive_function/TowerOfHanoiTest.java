package recursive_function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TowerOfHanoiTest {
    /*
     3번 R(1) = 3번 R(1) = [1,3]
     2번 R(2) = 3번 R(1) + 2번 R(1) = [1,3], [1,2], [3,2]
     (1,3) R(2) = (1,2) R(1) + (1,3) R(1) + (2,3) = [1,2], [1,3], [2,3]
     (1,3) R(3) = (1,2) R(2) + (1,3) R(1) + (2,3) R(2)= [1,3], [1,2], [3,2] +  [1,3] +  [2,1], [2,3], [1,3]

     3번 R(4) = 2번 R(3) + 3번 R(3)
     */
    @Test
    @DisplayName("하노이의 탑")
    void countMinimumMove() {
        Assertions.assertThat(TowerOfHanoi.solution(2)).isEqualTo(new int[][]{{1,2}, {1,3}, {2,3} });
    }

    private static class TowerOfHanoi {
        public static int[][] solution(int n) {

            getShortestPath(n);
            return new int[0][];
        }

        private static void getShortestPath(int n) {
        }
    }
}
