package basic;

public class StringHandling {
    public static boolean solution_1(String s) {
        if ((s.length() == 4 || s.length() == 6) && s.matches("[0-9]*")) {
            return true;
        }
        return false;
    }

    public static boolean solution_2(String s) {
        return (s.matches("[0-9]{4}||[0-9]{6}"));
    }

    public static boolean solution(String s) {
        if (s.length() !=4 && s.length() != 6)
            return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
