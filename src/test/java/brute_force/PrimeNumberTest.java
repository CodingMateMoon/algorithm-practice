package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimeNumberTest {

    // https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
    @Test
    @DisplayName("소수 찾기")
    void getPrimeNumber() {
        Assertions.assertThat(PrimeNumber.solution("12345")).isEqualTo(3);
        Assertions.assertThat(PrimeNumber.solution("17")).isEqualTo(3);
        Assertions.assertThat(PrimeNumber.solution("011")).isEqualTo(2);
    }

    private static class PrimeNumber {

        static boolean[] usedNumbers;
        static char[] cNumbers;

        public static int solution(String numbers) {



            cNumbers = numbers.toCharArray();
            int length = cNumbers.length;
            //usedNumbers = new boolean[numbers.length()];

//            for (int i = 0; i < length; i++) {
//                boolean[] usedNumbers = new boolean[numbers.length()];
//                usedNumbers[i] = true;
                recursion("");

//            }



            return 0;
        }

        public static void recursion(String sCase) {

            if(sCase.length() == cNumbers.length){
                System.out.println(sCase);
            }

            for (int i = 0; i < cNumbers.length; i++) {
                if( sCase.contains(String.valueOf(cNumbers[i]))){
                    continue;
                }
                sCase += cNumbers[i];
                recursion(sCase);
                sCase = sCase.substring(0, sCase.length() - 1);
            }
        }

        /*
        append(1) 1
        append(2) 1,2
        append(3) 1,2,3
        public static  recur( current){
           if(exitCondition == true)
             return answer + X
            next = current.somelogic();
            for n in (next) {
                recur(n);
            }

        }

         */
    }
}
