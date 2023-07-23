package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CaeserCipherTest {

    @Test
    @DisplayName("caeserCipher")
    void caeserCipher() {
        // given
        String result = CaeserCipher.solution("AB", 1);
        Assertions.assertThat(result).isEqualTo("BC");

    }

    @Test
    @DisplayName("caeserCipher")
    void caeserCipher2() {
        // given
        String result = CaeserCipher.solution("z", 1);
        Assertions.assertThat(result).isEqualTo("a");
    }

    @Test
    @DisplayName("caeserCipher")
    void caeserCipher3() {
        // given
        String result = CaeserCipher.solution("a B z", 4);
        Assertions.assertThat(result).isEqualTo("e F d");
    }

    @Test
    void test(){
        System.out.println((int)'a');
        System.out.println('z' - 'a');
        int circle = 'z' - 'a';
        System.out.println("circle : " + circle);
        char c = (char) ('a' + ('z' - 'a' + 1) % circle );
        System.out.println("c : " + c);
    }
}