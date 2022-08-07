import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        String[] inputs = bufferedReader.readLine().split(" ");

        int[] numberArray = new int[inputs.length];
        int[] numberSumArray = new int[inputs.length];

        for (int i = 0; i < numberArray.length; i++) {
            int number = Integer.parseInt(inputs[i]);
            numberArray[i] = number;
            if (i == 0) {
                numberSumArray[i] = number;
                continue;
            }
            numberSumArray[i] = numberSumArray[i - 1] + number;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            inputs = bufferedReader.readLine().split(" ");
            // 1 ~ 3 구간 -> 배열 기준 0 ~ 2
            int startIndex = Integer.parseInt(inputs[0]) - 1;
            int endIndex = Integer.parseInt(inputs[1]) - 1;
            stringBuilder.append(getIntervalSum(numberSumArray, startIndex, endIndex));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public static int getIntervalSum(int[] numberArray, int startIndex, int endIndex) {

        if (startIndex == 0) {
            return numberArray[endIndex];
        }
        return numberArray[endIndex] - numberArray[startIndex - 1];
    }
}
