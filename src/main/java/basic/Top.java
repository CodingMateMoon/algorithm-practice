package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Top { //
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] inputs = bufferedReader.readLine().split(" ");
        int[] topHeights = new int[n];
        for (int i = 0; i < n; i++) {
            topHeights[i] = Integer.parseInt(inputs[i]);
        }
        System.out.println(getLaserReceptionTop(topHeights));
    }

    public static String getLaserReceptionTop(int[] topHeights) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<int[]> stack = new Stack();
        for (int i = 0; i < topHeights.length; i++) {

            while (!stack.isEmpty()) {
                if (stack.peek()[1] > topHeights[i]) {
                    stringBuilder.append(stack.peek()[0]);
                    stringBuilder.append(" ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                stringBuilder.append("0 ");
            }

            int[] element = {i + 1, topHeights[i]};
            stack.push(element);
        }
        return stringBuilder.toString();
    }
}
