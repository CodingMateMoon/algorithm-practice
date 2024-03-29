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
        세로 3 이상, 가로 3 이상
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

        2(width + height) - 4 = brown
        width + height = (brown + 4) / 2
        3이상 (brown + yellow)의 약수
        => (brown + yellow)에 대해 3이상의 약수이면서 두 수의 합(제수, 피제수)이 (brown + 4) / 2를 만족하는 경우
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
        public static int[] solution_1(int brown, int yellow) {

            int area = brown + yellow;
            for (int divisor = 3; divisor < area / 2; divisor++) {
                if (area % divisor == 0) {
                    int quotient = area / divisor;
                    if ((divisor + quotient) == (brown + 4) / 2) {
                        return new int[]{quotient, divisor};
                    }
                }
            }
            return new int[0];
        }

        /*

         */
        public static int[] solution(int brown, int yellow) {

            for (int width = 3; width < 5000; width++) {
                for (int height = 0; height <= width; height++) {

                    int boundary = (width + height - 2) * 2;
                    int inside = width * height - boundary;

                    if (brown == boundary && yellow == inside) {
                        return new int[]{width, height};
                    }
                }

            }
            return null;
        }
    }
}
