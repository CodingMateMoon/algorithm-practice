package basic;

public class TriangleSnail3 {

    private static final int dy[] = {1, 0, -1};
    private static final int dx[] = {0, 1, -1};

    public static int[] solution(int n) {

        int x = 0;
        int y = 0;
        int v = 1;
        int nx = 0;
        int ny = 0;
        int index = 0;
        int[][] triangle = new int[n][n];


        while (true) {
            triangle[y][x] = v++;
            nx = x + dx[index];
            ny = y + dy[index];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                index = (index + 1) % 3;
                nx = x + dx[index];
                ny = y + dy[index];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0)
                    break;
            }
            x = nx;
            y = ny;
        }


        int[] result = new int[n * (n + 1) / 2];
        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index] = triangle[i][j];
                index++;
            }
        }
        return result;
    }
}
