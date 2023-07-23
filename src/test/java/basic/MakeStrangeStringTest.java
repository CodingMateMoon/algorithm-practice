package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MakeStrangeStringTest {

    @Test
    @DisplayName("make strange string")
    void makeStrangeString() {
        // given
        String result = MakeStrangeString.solution("try hello world");
        // expected
        Assertions.assertThat(result).isEqualTo("TrY HeLlO WoRlD");
    }
}