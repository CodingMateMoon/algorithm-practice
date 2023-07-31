package basic;

public class TernaryFlip {
    public static int reverseTernaryNumber_first(int n) {
        String ternaryNumber = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder();
        char[] numbers = ternaryNumber.toCharArray();
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            sb.append(numbers[i]);
        }
        return Integer.parseInt(sb.toString(), 3);
    }

    public static int reverseTernaryNumber(int n) {
        String ternaryNumber = Integer.toString(n, 3);
        String reversed = new StringBuilder(ternaryNumber).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }
}
