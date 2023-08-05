package basic;

public class NumberStringAndWords {
    public static int solution(String s) {
        char[] numberString = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int index = 0;
        for (int i = 0; i < numberString.length; i++) {
            if ('0' <= numberString[i] && numberString[i] <= '9') {
                sb.append(numberString[i]);
                continue;
            }
            for (int j = 0; j < words.length; j++) {

                if (s.startsWith(words[j], i)) {
                    sb.append(j);
                    i += words[j].length() - 1 ;
                    break;
                }
            }

        }
        return Integer.parseInt(sb.toString());
    }
}
