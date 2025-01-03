package arrays_strings;

public class ReverseString {
    public static char[] reverseString(char[] s) {

        int start_index = 0;
        int last_index = s.length - 1;
        while (start_index < last_index) {
           char temp = s[start_index];
           s[start_index] = s[last_index];
           s[last_index] = temp;
           start_index++;
           last_index--;
        }
        return s;
    }
}
