package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExamTest {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42840
    /*
    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     */
    @Test
    @DisplayName("모의고사")
    void getWinner() {
        Assertions.assertThat(Exam.solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1});
        Assertions.assertThat(Exam.solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1,2,3});

    }

    private static class Exam {
        public static int[] solution(int[] answers) {
            return new int[0];
        }
    }
}
