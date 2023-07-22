package basic;

public class ReverseNumber {
    public static int[] solution(long l) {
        String number = Long.toString(l);
        String reversedNumber = new StringBuilder(number).reverse().toString();
        char[] numbers = reversedNumber.toCharArray();
        int length = numbers.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {

            answer[i] = numbers[i] - '0';
        }

        return answer;
    }
}
