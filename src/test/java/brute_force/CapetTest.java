package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CapetTest {
    @Test
    @DisplayName("카펫")
    void getArea() {
        /*
        https://school.programmers.co.kr/learn/courses/30/lessons/42842
        8 <= brown <= 5000
        1 <= yellow <= 2000000
        세로 <= 가로
        세로 2 이상, 가로 2 이상
        10 + 2 = 12 = 4 * 3
        (4 + 3) * 2 - 4 = 10 (brown)
        8 + 1 = 9 = 3 * 3
        (3 + 3) * 2 - 4 = 8 (brown)
        24 + 24 = 48 = 8 * 6
        (8 + 6) * 2 - 4 = 24 (brown)
        (10, 2) -> (4,3)
        ㅁㅁㅁㅁ
        ㅁㅇㅇㅁ
        ㅁㅁㅁㅁ

        (8, 1) -> (3, 3)
        ㅁㅁㅁ
        ㅁㅇㅁ
        ㅁㅁㅁ

        (24, 24)-> (8,6)
        ㅁㅁㅁㅁㅁㅁ
        ㅁㅇㅇㅇㅇㅁ
        ㅁㅇㅇㅇㅇㅁ
        ㅁㅇㅇㅇㅇㅁ
        ㅁㅇㅇㅇㅇㅁ
        ㅁㅁㅁㅁㅁㅁ
         */
        Assertions.assertThat(Capet.solution(10, 2)).isEqualTo(new int[]{4, 3});
        Assertions.assertThat(Capet.solution(8, 1)).isEqualTo(new int[]{3, 3});
        Assertions.assertThat(Capet.solution(24, 24)).isEqualTo(new int[]{8, 6});
    }

    private static class Capet {
        public static int[] solution(int brown, int yellow) {

            return new int[0];
        }
    }
}
