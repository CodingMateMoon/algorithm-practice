package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountIntersectionTest {
    @Test
    @DisplayName("test")
    void test() {
        // given
        int line[][] = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};



        // 출력할 배열에 대해 y축 최소값과 최대값이 차로 세로 길이, x축 최소값과 최대값의 차로 가로 길이 구하기
        String[] result = CountIntersection.solution(line);
        Arrays.stream(result).forEach(row -> System.out.println(row));
    }

    @Test
    @DisplayName("test")
    void test2() {
        // given
        int line[][] = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        // 출력할 배열에 대해 y축 최소값과 최대값이 차로 세로 길이, x축 최소값과 최대값의 차로 가로 길이 구하기
        String[] result = CountIntersection.solution(line);
        Arrays.stream(result).forEach(row -> System.out.println(row));
    }


}
