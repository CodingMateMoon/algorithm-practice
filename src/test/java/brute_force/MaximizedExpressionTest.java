package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximizedExpressionTest {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/67257
    "100-200*300-500+20"	60420 // * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420


    "50*6-3*2"	300 // - > * 연산자 우선순위를 정한다면 50*(6-3)*2
    연산자 우선순위에 따라 나올 수 있는 모든 경우에 대한 값 중 최대값을 구합니다.
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
        public static long solution(String s) {
            return 0;
        }
    }
}
