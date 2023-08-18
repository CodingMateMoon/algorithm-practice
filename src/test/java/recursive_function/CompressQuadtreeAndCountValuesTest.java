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
        (3) (0,0) ~ (2^n-1, 2^n-1), (2^n-1,0) ~ (2^n-1,2^n), (0, 2^n-1) ~ (2^n-1, 2^n), (2^n-1, 2^n-1)~(2^n, 2^n) 모두 같은 값(0 또는 1)인지 계산
        상태 (n, n)
         */
        // given
        Assertions.assertThat(new CompressQuadtreeAndCountValues().solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})).isEqualTo(new int[]{4, 9});
        Assertions.assertThat(new CompressQuadtreeAndCountValues().solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})).isEqualTo(new int[]{10, 15});
        // expected
    }

    private static class CompressQuadtreeAndCountValues {
        public  int[] solution(int[][] arr) {
            Count answer = calculateQuadtreeValue(arr, arr.length, 0, 0);

            return new int[]{answer.zero,answer.one};
        }

        public  Count calculateQuadtreeValue(int[][] arr, int length, int offsetX, int offsetY) {

            int nextLength = length / 2;

            for (int y = offsetY; y < offsetY + length; y++) {
                for (int x = offsetX; x < offsetX + length; x++) {
                    if (arr[offsetY][offsetX] != arr[y][x]) {
                        return calculateQuadtreeValue(arr, nextLength, offsetX, offsetY)
                                .plus(calculateQuadtreeValue(arr, nextLength, offsetX + nextLength, offsetY))
                                .plus(calculateQuadtreeValue(arr, nextLength, offsetX, offsetY + nextLength))
                                .plus(calculateQuadtreeValue(arr, nextLength, offsetX + nextLength, offsetY + nextLength));
                    }
                }
            }

            if (arr[offsetY][offsetX] == 0) {
                return new Count(1, 0);
            }
            return new Count(0, 1);
        }

        public static class Count {
            final int zero;
            final int one;

            public Count(int zero, int one) {
                this.zero = zero;
                this.one = one;
            }

            public Count plus(Count other) {
                return new Count(this.zero + other.zero, this.one + other.one);
            }
        }

    }
}
