package basic;

public class StringHandling {
    public static boolean solution(String s) {
        if ((s.length() == 4 || s.length() == 6) && s.matches("[0-9]*")) {
            return true;
        }
        return false;
    }
}
