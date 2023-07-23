package basic;

public class MakeStrangeString {
    public static String solution(String s) {
        char[] words = s.toCharArray();
        char[] result = new char[words.length];
        boolean toUpper = true;
        for (int i = 0; i < words.length; i++) {
            char c = words[i];
            if (!Character.isAlphabetic(c)) {
                result[i] = ' ';
                toUpper = true;
                continue;
            }

            if (toUpper) {
                result[i] = Character.toUpperCase(c);
                toUpper = false;
                continue;
            }

            result[i] = Character.toLowerCase(c);
            toUpper = true;
        }
        return String.valueOf(result);
    }
    public static String solution_first(String s) {
        char[] words = s.toCharArray();
        char[] result = new char[words.length];
        int oddEvenIndex = 0;
        for (int i = 0; i < words.length; i++) {
            char c = words[i];
            if (c == ' ') {
                oddEvenIndex = 0;
                result[i] = ' ';
                continue;
            }
            result[i] = makeUpperLowerCase(c, oddEvenIndex++);
        }
        return String.valueOf(result);
    }

    private static char makeUpperLowerCase(char c, int oddEvenIndex) {
        if (oddEvenIndex % 2 == 0) {
            return Character.toUpperCase(c);
        }
        return Character.toLowerCase(c);
    }
}
