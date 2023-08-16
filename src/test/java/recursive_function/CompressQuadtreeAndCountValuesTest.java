package recursive_function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompressQuadtreeAndCountValuesTest {
    @Test
    @DisplayName("쿼드압축 후 개수 세기")
    void compressQuadtreeAndCountValuesTest() {
        /*
        4등분으로 나누고 값이 전부 1인 경우 1 한 개, 전부 0인 경우 0 한 개로 count 합니다.
        (1) n = 1, 길이가 2x2일 때 1,0이 섞여있어서 압축이 불가능한 상태까지 나눈 경우, 값이 모두 0 또는 1인 경우에 대해 return (zeroCount, oneCount)
        (2) 2^n - e.g, 2^3일 때 2^2 4개의 사각형으로 나누고 각 사각형에서 모든 수가 같은 값인지 확인
        (3) 0 ~ 2^n-1, 2^n-1 ~ 2^n 모두 같은 값(0 또는 1)인지 계산. 0 ~ x/2, x/2 ~ x
        상태 (n, n)
         */
        // given
        Assertions.assertThat(CompressQuadtreeAndCountValues.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})).isEqualTo(new int[]{4, 9});
        Assertions.assertThat(CompressQuadtreeAndCountValues.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})).isEqualTo(new int[]{10, 15});
        // expected
    }

    private static class CompressQuadtreeAndCountValues {
        public static int[] solution(int[][] arr) {

            return new int[0];
        }

        public static int[] calculateQuadtreeValue(int[][] arr, int startIndex, int endIndex) {

            int length = 1;
            int zeroCount = 0;
            int oneCount = 0;

            for (int i = 0; i < n; i++) {
                length *= 2;
            }

            int standardNumber = -1;
            boolean isCompressed = true;
            for (int y = 0; y < length / 2; y++) {
                for (int x = 0; x < length / 2; x++) {
                    if (y == 0 && x == 0) {
                        standardNumber = arr[y][x];
                        continue;
                    }
                    if (standardNumber != arr[y][x]) {
                        isCompressed = false;
                        break;
                    }
                }
            }


            calculateQuadtreeValue(arr, 0, n / 2);
            calculateQuadtreeValue(arr,  n / 2,  n);


            if (isCompressed) {
                if (standardNumber == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if (n == 1) {
                return new int[]{zeroCount, oneCount};
            }

            return new int[]{0,0};
        }


    }
}
