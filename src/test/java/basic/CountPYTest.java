package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountPYTest {

    @Test
    @DisplayName("문자열 내 p와 y의 개수")
    void 문자열_내_p와_y의_개수() {
        Assertions.assertThat(CountPY.solution("pPoooyY")).isTrue();
        Assertions.assertThat(CountPY.solution("Pyy")).isFalse();
    }
}