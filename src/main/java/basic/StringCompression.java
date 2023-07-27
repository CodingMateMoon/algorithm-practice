package basic;

public class StringCompression {
    public static int solution(String s) {

        /*
        단위 unit 1 ~ n/2 까지 각각 압축했을 때 길이를 구하고 가장 짧은 경우에 대해 min으로 저장해서 return합니다.
        n = 10 일 경우 배열 기준 단위를 이루는 인덱스는 0 ~ 4(10/2 - 1[maxUnit - 1]), 비교군 인덱스는 5(10/2) ~ 9
        n = 9 일 경우 배열 기준 단위를 이루는 인덱스는 0 ~ 3(9/2 - 1[maxUnit - 1]), 비교군 인덱스는 4(9/2) ~ 8
        unit 1 기준 : i == i + 1 인 경우 compressedCnt++, compressCnt 1일 때 다시 i = i + 1인 경우 length--
        unit 2 기준 : elements 01 != 23 -> continue. 01 == 23 -> list에 저장 후 lenth += 2. 요소 하나 하나 진행할 때 마다 length를 구하는 등 필요한 작업을 처리합니다.
        unit 단위로 리스트를 구하고 값이 같은 경우 count++, count > 1 일때 StringBuilder compressedString에 값을 추가합니다.
         */
        char[] elements = s.toCharArray();

        int min = Integer.MAX_VALUE;
        int unit = 1;
        int maxUnit = elements.length / 2;
        for (int i = unit; i <= maxUnit; i++) {

            String compressedString = compressString(s, unit);
        }
        return 0;
    }

    private static String compressString(String s, int unit) {

        
        for (int i= 0; i < s.length(); i+=unit) {

        }
    }
}
