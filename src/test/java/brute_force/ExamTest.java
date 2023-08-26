package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExamTest {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42840
    /*
    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, / 1, 2, 3, 4, 5, ... 5개 반복
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5/ 2, 1, 2, 3, 2, 4, 2, 5, ... 8개 반복
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, / 3,  3, 1, 1, 2, 2, 4, 4, 5, 5, ... 10개 반복

    1,2,3 수포자별로 repeatLength를 기준으로 삼아 answer를 순회하는 index에 대해 repeatLength로 나머지 연산을 해서 elements의 요소들과 각각 비교를 통해 matchCount가 max인 수포자를 구합니다.

     */
    @Test
    @DisplayName("모의고사")
    void getWinner() {
        Exam.solution(new int[]{1, 2, 3, 4, 5});
        Assertions.assertThat(Exam.solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1});
        Assertions.assertThat(Exam.solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1,2,3});

    }

    private static class Exam {

        static final int[][] persons = new int[][]{{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        public static int[] solution(int[] answers) {
            int max = Integer.MIN_VALUE;
            int[] scores = new int[3];
            for (int i = 0; i < 3; i++) {
                int matchCount = 0;
                int repeatLength = persons[i].length;
                for (int j = 0; j < answers.length; j++) {
                    int index = j % repeatLength;
                    if (persons[i][index] == answers[j]) {
                        matchCount++;
                    }
                }
                scores[i] = matchCount;
            }
            
            return new int[0];
        }
    }
}
