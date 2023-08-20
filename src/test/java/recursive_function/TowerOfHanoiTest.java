package recursive_function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoiTest {
    /*
     3번 R(1) = 3번 R(1) = [1,3]
     R(3, 1, 3) = R(2, 1, 2) + R(1, 1, 3) + R(2,2,3)
     R(2,1,2) = R(1,1,3) + R(1,1,2) + R(1,3,1) = [1,3], [1,2], [3,2]
     (1,2) R(2) = 3번 R(1) + 2번 R(1) = [1,3], [1,2], [3,2]
     (1,3) R(2) = (1,2) R(1) + (1,3) R(1) + (2,3) R(1) = [1,2], [1,3], [2,3]
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
            List<int[]> answer = new ArrayList<>();
            countMinimumMove(n, 1, 3, answer);
            return answer.toArray(new int[0][]);
        }

        private static void countMinimumMove(int n, int from, int to, List<int[]> moves) {
            if (n == 1) {
                moves.add(new int[]{from, to});
                return;
            }
            int empty = 6 - from - to;
            countMinimumMove(n - 1, from, empty, moves);
            countMinimumMove(1, from, to, moves);
            countMinimumMove(n - 1, empty, to, moves);
        }
        public static int[][] solution_1(int n) {

            return countMinimumMove_1(n, 1, 3).toArray(new int[0][]);
        }

        private static List<int[]> countMinimumMove_1(int n, int from, int to) {
            if (n == 1) {
                return List.of(new int[]{from, to});
            }
            int empty = 6 - from - to;
            List<int[]> moves = new ArrayList<>();
            moves.addAll(countMinimumMove_1(n - 1, from, empty));
            moves.addAll(countMinimumMove_1(1, from, to));
            moves.addAll(countMinimumMove_1(n - 1, empty, to));
            return moves;
        }
    }
}
