package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringHandlingTest {
    @Test
    @DisplayName("문자열 다루기")
    void 문자열_다루기() {
        Assertions.assertThat(StringHandling.solution("a234")).isFalse();
        Assertions.assertThat(StringHandling.solution("1234")).isTrue();
    }
}