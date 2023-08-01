package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class 이진변환_반복하기Test {

    @Test
    @DisplayName("이진변환 반복하기")
    void repeatBinaryConversion() {
        Assertions.assertThat(이진변환_반복하기.solution("110010101001")).isEqualTo(new int[]{3, 8});
        Assertions.assertThat(이진변환_반복하기.solution("01110")).isEqualTo(new int[]{3, 3});
        Assertions.assertThat(이진변환_반복하기.solution("1111111")).isEqualTo(new int[]{4, 1});
    }
}