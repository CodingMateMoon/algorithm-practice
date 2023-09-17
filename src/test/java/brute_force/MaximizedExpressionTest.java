package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MaximizedExpressionTest {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/67257
    "100-200*300-500+20"	60420 // * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은-60420
    피연산자5개, 연산자4개
    = 100-(200*300)-500+20
    = 100-60000-(500+20)
    = (100-60000)-520
    = (-59900-520)
    = -60420
    연산자 최대 개수n/2, 연산자 탐색n, 탐색 후 연산한 뒤 피연산자 리스트 정리n. 우선 순위 경우의 수3! -> n/2 * n * n * 3! = 3 * n^3 = 3000000
    3 <= n <= 100
    1 - 2 * 3 * 4 + 5
    0   1   2   3   4
      0   1   2   3
     i + 1 에 연산 결과값을 저장하고remove(i)



    "50*6-3*2"	300 // - > * 연산자 우선순위를 정한다면50*(6-3)*2
    연산자 우선순위에 따라 나올 수 있는 모든 경우에 대한 값 중 최대값을 구합니다.
    연산자를 순차적으로 조회하면서 위치를 확인하고 i번째 인덱스 연산자와 i+1번째 인덱스 연산자 중 우선순위가 높은 연산자를 중심으로 먼저 계산합니다.
    연산자(*, +, -) 기준으로 숫자 구분.
    int[] numbers = {100, 200, 300, 500, 20}
    char[] operations = {'-', '*', '-', '+'}
    * + -
    우선 순위 3!에 대해 각각 계산
    * + -
    * - +
    + * -
    + - *
    - * +
    - + *

    int[] priorities = {0, 1, 2}
    0번째 연산자 -, 1번째 연산자 * 중 우선 순위
    3 <= expression.length <= 100
    0 <= 피연산자(operand) <= 999
    expression 중간 계산값과 최종 결괏값은 절댓값이2^63 - 1 이하
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

        static final char[][] cases = {{'*', '+', '-'}, {'*', '-', '+'}, {'+','*', '-'}, {'+', '-', '*'}, {'-', '*', '+'}, {'-', '+', '*'}};
        public static long solution(String s) {
            long answer = 0;
            List<Integer> operands = new ArrayList<>();
            List<Character> operations = new ArrayList<>();

            int endOffset = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*' || c == '+' || c == '-') {
                    if (endOffset < 0) {

                        operands.add(Integer.parseInt(s.substring(0, i)));
                        operations.add(c);
                        endOffset = i + 1;
                        continue;
                    }
                    operands.add(Integer.parseInt(s.substring(endOffset, i)));
                    operations.add(c);
                    endOffset = i + 1;
                }
            }
            operands.add(Integer.parseInt(s.substring(endOffset)));

            /*
            "100-200*300-500+20"	60420 // * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은-60420
            피연산자5개, 연산자4개
            = 100-(200*300)-500+20
            = 100-60000-(500+20)
            = (100-60000)-520
            = (-59900-520)
            = -60420
            연산자 최대 개수n/2, 연산자 탐색n, 탐색 후 연산한 뒤 피연산자 리스트 정리n. 우선 순위 경우의 수3! -> n/2 * n * n * 3! = 3 * n^3 = 3000000
            3 <= n <= 100
            1 - 2 * 3 * 4 + 5
            0   1   2   3   4
              0   1   2   3
            operands 요소i + 1 에 연산 결과값을 저장하고remove(i)
            해당operationOffset에 해당하는operation 요소remove
             */
            long max = Long.MIN_VALUE;
            for (int pCase = 0; pCase < cases.length; pCase++) {
                List<Long> caseOperands = new ArrayList<Long>();
                for (Integer operand : operands) {
                    caseOperands.add(Long.valueOf(operand));
                }
                List<Character> caseOperations = new ArrayList<>(operations);
                //System.out.println(Math.abs(getCalculationResult(pCase, caseOperands, caseOperations)));
                max = Math.max(max, Math.abs(getCalculationResult(pCase, caseOperands, caseOperations)));
            }

            return max;
        }

        private static long getCalculationResult(int pCase, List<Long> caseOperands, List<Character> caseOperations) {
            for (int element = 0; element < 3; element++) {
                for (int operationOffset = 0; operationOffset < caseOperations.size(); operationOffset++) {
                    char c = cases[pCase][element];
                    if (caseOperations.size() == 0) {
                        return caseOperands.get(0);
                    }
                    if (c == caseOperations.get(operationOffset)) {
                        long tempResult = calculate(caseOperands, c, operationOffset);
                        caseOperands.remove(operationOffset);
                        caseOperands.remove(operationOffset);
                        caseOperands.add(operationOffset, tempResult);
                        caseOperations.remove(operationOffset);
                        operationOffset -= 1;
                    }
                }
            }
            return caseOperands.get(0);
        }

        private static long calculate(List<Long> caseOperands, char operation, int operationOffset) {
            long result = 0;
            switch (operation) {
                case '*':
                    result = caseOperands.get(operationOffset) * caseOperands.get(operationOffset + 1);
                    break;

                case '+':
                    result = caseOperands.get(operationOffset) + caseOperands.get(operationOffset + 1);
                    break;

                case '-':
                    result = caseOperands.get(operationOffset) - caseOperands.get(operationOffset + 1);
                    break;

            }
            return result;
        }

    }
}
