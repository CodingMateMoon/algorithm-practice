package basic;

public class MatrixMultiplication {
    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int rows = arr1.length;
        int cols = arr2[0].length;
        int length = arr1[0].length;
        int[][] answer = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
