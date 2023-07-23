package basic;

public class CaeserCipher {
    public static String solution(String s, int n) {
        char[] elements = s.toCharArray();
        char[] results = new char[elements.length];
        int circle = 'z' - 'a' + 1;
        for (int i = 0; i < elements.length; i++) {
            char element = elements[i];
            if (element == ' ') {
                results[i] = ' ';
                continue;
            }

            if ('a' <= element && element <= 'z') {
                results[i] = (char) ('a' + (element - 'a' + n) % circle);
                continue;
            }
            results[i] = (char) ('A' + (element - 'A' + n) % circle);
            System.out.println("final - " + element + " : " + results[i]);
        }


        return String.valueOf(results);
    }
}
