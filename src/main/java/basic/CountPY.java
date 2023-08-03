package basic;

public class CountPY {
    public static boolean solution_first(String s) {
        int pCount = 0;
        int yCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {
                pCount++;
                continue;
            }

            if (c == 'y' || c == 'Y') {
                yCount++;
            }
        }

        if (pCount != yCount) {
            return false;
        }
        return true;
    }

    public static boolean solution_2(String s) {
        int pCount = 0;
        int yCount = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p','P'-> pCount++;
                case 'y','Y'-> yCount++;
            }
        }

        return pCount == yCount;
    }

    public static boolean solution(String s) {

        s.toLowerCase();
        return s.chars().filter(e -> 'p' == e).count() == s.chars().filter(e -> 'y' == e).count();
    }
}

