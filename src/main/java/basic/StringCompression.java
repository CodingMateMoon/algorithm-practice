package basic;

public class StringCompression {
    public static int solution(String s) {

        /*
        단위 unit 1 ~ n/2 까지 각각 압축했을 때 길이를 구하고 가장 짧은 경우에 대해 min으로 저장해서 return합니다.
        n = 10 일 경우 배열 기준 단위를 이루는 인덱스는 0 ~ 4(10/2 - 1[maxUnit - 1]), 비교군 인덱스는 5(10/2) ~ 9
        n = 9 일 경우 배열 기준 단위를 이루는 인덱스는 0 ~ 3(9/2 - 1[maxUnit - 1]), 비교군 인덱스는 4(9/2) ~ 8
         */
        char[] elements = s.toCharArray();

        int min = 0;
        int maxUnit = elements.length / 2;
        for (int i = 0; i < elements.length; i++) {

        }
        return 0;
    }
}
