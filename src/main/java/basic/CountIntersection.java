package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountIntersection {

    static class Point {
        public final long x;
        public final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    "}";
        }
    }

    public static Point createPoint(int arr1[], int arr2[]) {

        long divide = ((long)arr1[0] * (long)arr2[1] - (long)arr1[1] * (long)arr2[0]);
        double x = (double) ((long)arr1[1] * (long)arr2[2] - (long)arr1[2] * (long)arr2[1]) / divide;
        double y = (double) ((long)arr1[2] * (long)arr2[0] - (long)arr1[0] * (long)arr2[2]) / divide;
        if (x % 1 != 0 || y % 1 != 0)
            return null;
        return new Point((long)x, (long) y);
    }

    public static String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        // when
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point p = createPoint(line[i], line[j]);
                if (p != null) {
                    points.add(p);
                }
            }
        }

//        long maxX = points.get(0).x;
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point p : points) {
            long px = p.x;
            long py = p.y;
            if(px > maxX)
                maxX = px;
            if(px < minX)
                minX = px;
            if(py > maxY)
                maxY = py;
            if(py < minY)
                minY = py;
        }
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] printArr = new char[height][width];
        for (char[] row : printArr) {
            Arrays.fill(row, '.');
        }
        /*
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                printArr[i][j] = '.';
            }
        }
         */

        for (Point point : points) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            printArr[y][x] = '*';
        }
        // then

        String[] result = new String[height];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(printArr[i]);
        }
        return result;
    }
}
