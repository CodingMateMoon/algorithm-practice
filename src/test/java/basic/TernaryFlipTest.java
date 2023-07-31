package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TernaryFlipTest {

    @Test
    @DisplayName("reverseTernaryNumber")
    void reverseTernaryNumber() {
        Assertions.assertThat(TernaryFlip.reverseTernaryNumber(45)).isEqualTo(7);
        Assertions.assertThat(TernaryFlip.reverseTernaryNumber(125)).isEqualTo(229);

    }
}