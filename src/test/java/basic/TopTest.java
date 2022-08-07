package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopTest {

    @Test
    void 레이저수신_탑_높이_구하기() {
        int[] topHeights = {6, 9, 5, 7, 4};
        Assertions.assertThat(Top.getLaserReceptionTop(topHeights)).isEqualTo("0 0 2 2 4 ");

        int[] topHeights2 = {6, 9, 5, 7, 4, 3};
        Assertions.assertThat(Top.getLaserReceptionTop(topHeights2)).isEqualTo("0 0 2 2 4 5 ");
    }
}
