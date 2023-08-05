package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberStringAndWordsTest {

    /*
    숫자는 그대로 읽고 zero, one, two, three, four, five, six, seven, eight, nine은 숫자로 변경
     */
    @Test
    @DisplayName("숫자 문자열과 영단어")
    void covertNumberStringToNumber() {

        Assertions.assertThat(NumberStringAndWords.solution("one4seveneight")).isEqualTo(1478);
        Assertions.assertThat(NumberStringAndWords.solution("23four5six7")).isEqualTo(234567);
        Assertions.assertThat(NumberStringAndWords.solution("2three45sixseven")).isEqualTo(234567);
        Assertions.assertThat(NumberStringAndWords.solution("123")).isEqualTo(123);
    }
}