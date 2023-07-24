package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCompressionTest {

    @Test
    @DisplayName("compressString")
    void compressString() {
        Assertions.assertThat(StringCompression.solution("aabbaccc")).isEqualTo(7);
        Assertions.assertThat(StringCompression.solution("ababcdcdababcdcd")).isEqualTo(9);
        Assertions.assertThat(StringCompression.solution("abcabcdede")).isEqualTo(8);
        Assertions.assertThat(StringCompression.solution("abcabcabcabcdededededede")).isEqualTo(14);
        Assertions.assertThat(StringCompression.solution("xababcdcdababcdcd")).isEqualTo(17);
    }
}