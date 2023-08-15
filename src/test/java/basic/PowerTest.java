package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PowerTest {

    /*
    1. 상태 정의하기
    (n, m)

    2. 종료 조건
    n^0 = 1 -> m = 0이 될 때 종료

    3. 점화식

    (n, m) = n * (n, m - 1)
     */

    @Test
    @DisplayName("n의 m제곱 계산")
    void power() {
        // given
        Assertions.assertThat(Power.power(2, 3)).isEqualTo(8);
        Assertions.assertThat(Power.power(2, 4)).isEqualTo(16);
        Assertions.assertThat(Power.power(3, 4)).isEqualTo(81);
        // expected
    }

    private static class Power {
        public static int power(int n, int m) {
            if (n == 0) return 1;
            if (m == 0) return 1;
            if (n == 1) return 1;
            return n * power(n, m - 1);
        }
    }
}
