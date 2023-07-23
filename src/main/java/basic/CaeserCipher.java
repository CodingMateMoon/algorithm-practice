package basic;

public class CaeserCipher {
    public static String solution(String s, int n) {
        char[] elements = s.toCharArray();
        char[] results = new char[elements.length];
        for (int i = 0; i < elements.length; i++) {
            char element = elements[i];
            results[i] = push(element, n);
        }
        return String.valueOf(results);
    }

    public static char push(char c, int n) {
        if (!Character.isAlphabetic(c))
            return c;

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = (c - offset + n) % ('z' - 'a' + 1);
        return (char) (offset + position);
    }

    public static String Solution_backup(String s, int n) {
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
