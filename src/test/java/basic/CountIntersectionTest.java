package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CountIntersectionTest {
    @Test
    @DisplayName("test")
    void test() {
        // given
        int line[][] = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};

        List<Point> points = new ArrayList<>();
        // when
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (CountIntersection.checkIntersection(line[i], line[j])) {
                    points.add(CountIntersection.createPoint(line[i], line[j]));
                }
            }
        }

        // 정렬 후 양 끝 y축 차를 구해서
        for (Point point : points) {
            System.out.println(point);
        }
        // then
    }

}
