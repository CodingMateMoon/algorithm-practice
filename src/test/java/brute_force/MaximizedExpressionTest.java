package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximizedExpressionTest {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/67257
    "100-200*300-500+20"	60420 // * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60420
    = 100-(200*300)-500+20
    = 100-60000-(500+20)
    = (100-60000)-520
    = (-59900-520)
    = -60420


    "50*6-3*2"	300 // - > * 연산자 우선순위를 정한다면 50*(6-3)*2
    연산자 우선순위에 따라 나올 수 있는 모든 경우에 대한 값 중 최대값을 구합니다.
    연산자를 순차적으로 조회하면서 위치를 확인하고 i번째 인덱스 연산자와 i+1번째 인덱스 연산자 중 우선순위가 높은 연산자를 중심으로 먼저 계산합니다.
    연산자 (*, +, -) 기준으로 숫자 구분.
    int[] numbers = {100, 200, 300, 500, 20}
    char[] operations = {'-', '*', '-', '+'}
    * + -
    우선 순위 3!에 대해 각각 계산
    0 1 2
    0 2 1
    1 0 2
    1 2 0
    2 0 1
    2 1 0

    int[] priorities = {0, 1, 2}
    0번째 연산자 -, 1번째 연산자 * 중 우선 순위
    3 <= expression.length <= 100
    0 <= 피연산자(operand) <= 999
    expression 중간 계산값과 최종 결괏값은 절댓값이 2^63 - 1 이하
     */
    @Test
    @DisplayName("수식 최대화")
    void maximizeExpression() {
        // given
        Assertions.assertThat(MaximizedExpression.solution("100-200*300-500+20")).isEqualTo(60420);
        Assertions.assertThat(MaximizedExpression.solution("50*6-3*2")).isEqualTo(300);
        // expected
    }

    private static class MaximizedExpression {

        static final int[][] cases = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
        public static long solution(String s) {
            List<String> operands = new ArrayList<>();
            List<Character> operations = new ArrayList<>();

            Map<Character, Integer> priorities = new HashMap<>();
            int endOffset = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*' || c == '+' || c == '-') {
                    if (endOffset < 0) {

                        operands.add(s.substring(0, i));
                        operations.add(c);
                        endOffset = i + 1;
                        continue;
                    }
                    operands.add(s.substring(endOffset, i));
                    operations.add(c);
                    endOffset = i + 1;
                }
            }
            operands.add(s.substring(endOffset));

            for (int pCase = 0; pCase < cases.length; pCase++) {
                setPriority(cases, priorities, pCase);
                // 연산자 i, i+1 비교 후 i가 우선순위에서 더 큰 경우 i+1 연산자 좌우 피연산자에 대해 연산
                for (int operationIndex = 0; operationIndex < operations.size() - 1; operationIndex++) {
                    for (int comparedIndex = operationIndex + 1; comparedIndex < operations.size(); comparedIndex++) {

                    }
                }
            }

            return 0;
        }

        private static void setPriority(int[][] cases, Map<Character, Integer> priorities, int pCase) {
            for (int element = 0; element < 3; element++) {
                switch(element){
                    case 0:
                        priorities.put('*', cases[pCase][element]);
                        break;
                    case 1:
                        priorities.put('+', cases[pCase][element]);
                        break;
                    case 2:
                        priorities.put('-', cases[pCase][element]);
                        break;
                }
            }
        }
    }
}
