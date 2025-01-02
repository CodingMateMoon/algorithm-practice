package basic;

import java.util.Arrays;

public class NumberSum {
    public static int getNumberSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
