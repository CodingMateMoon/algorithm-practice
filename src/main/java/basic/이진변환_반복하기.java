package basic;

public class 이진변환_반복하기 {

    /* 입력받은 문자열을 toCharArray(), 한글자씩 조회하면서 1이면 length++, 0일 경우 removeCount++,
    조회가 끝난 후 length를 이진수로 변환 Interger.toString(length, 2), convertCount++, 결과값이 "1"이 될때까지 반복
    return new int[]{convertCount, removeCount}

     */
    public static int[] solution_first(String s) {

        int length = 0;
        int removeCount = 0;
        int convertCount = 0;
        char[] input = s.toCharArray();
        while (length != 1){
            length = 0;

            for (int i = 0; i < input.length; i++) {
                if (input[i] == '1') {
                    length++;
                    continue;
                }
                removeCount++;
            }
            convertCount++;
            input = Integer.toString(length, 2).toCharArray();
        }

        return new int[]{convertCount, removeCount};
    }

    public static int[] solution(String s) {

        int length = 0;
        int removeCount = 0;
        int convertCount = 0;
        char[] input = s.toCharArray();
        while (length != 1){
            int zeros = countZeros(s);
            removeCount += zeros;
            length = s.length() - zeros;
            s = Integer.toString(length, 2);
            convertCount++;
        }

        return new int[]{convertCount, removeCount};
    }

    private static int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zeros++;
        }
        return zeros;
    }

}
