package basic;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
    public static int solution(String s) {

        /*
        단위 unit 1 ~ n/2 까지 각각 압축했을 때 길이를 구하고 가장 짧은 경우에 대해 min으로 저장해서 return합니다.
        n = 10 일 경우 배열 기준 단위를 이루는 인덱스는 0 ~ 4(10/2 - 1[maxUnit - 1]), 비교군 인덱스는 5(10/2) ~ 9
        n = 9 일 경우 배열 기준 단위를 이루는 인덱스는 0 ~ 3(9/2 - 1[maxUnit - 1]), 비교군 인덱스는 4(9/2) ~ 8
        이전 단위 요소 last와 다음 단위 요소 token를 서로 비교하고 같은 경우 count를 늘리며 다른 경우 StringBuilder에 last값을 추가하고 token을 last에 입력. + count가 2 이상인 경우 해당값도 추가.
        substring을 활용해서 unit 단위로 리스트를 구하고 리스트 내 항목들 간에 값이 서로 같은 경우 count++, count > 1 일때 StringBuilder compressedString에 값을 추가합니다.
         */
        char[] elements = s.toCharArray();

        int min = Integer.MAX_VALUE;
        int unit = 1;
        int maxUnit = elements.length ;
        for (int i = unit; i <= maxUnit; i++) {
            String compressedString = compressString(s, i);
            min = Math.min(compressedString.length(), min);
        }
        return min;
    }

    private static String compressString(String s, int unit) {

        String last = "";
        int index = 0;
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (String token : split(s, unit)) {
            if (index == 0) {
                last = token;
                index++;
                continue;
            }

            if (token.equals(last)) {
                count++;
                continue;
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(last);
            last = token;
            count = 1;
        }
        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);
        return sb.toString();
    }

    private static List<String> split(String s, int unit) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < s.length(); i+=unit) {
            if ((i + unit) > s.length()) {
                tokens.add(s.substring(i, s.length()));
            } else {
                tokens.add(s.substring(i, i + unit));
            }
        }
        return tokens;
    }


}
