package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberTest {

    // https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
    @Test
    @DisplayName("소수 찾기")
    void getPrimeNumber() {
//        Assertions.assertThat(PrimeNumber.solution("12345")).isEqualTo(3);
        Assertions.assertThat(PrimeNumber.solution("17")).isEqualTo(3);
        Assertions.assertThat(PrimeNumber.solution("011")).isEqualTo(2);
    }

    private static class PrimeNumber {

        static boolean[] usedNumbers;
        static char[] cNumbers;

        static int[] iNumbers;

        static Set<Integer> primeNumbers;

        public static int solution(String numbers) {

            iNumbers = numbers.chars().map(c -> c - '0').toArray();
            int length = iNumbers.length;
            primeNumbers = new HashSet<>();
            usedNumbers = new boolean[numbers.length()];

            recursion(0);
            return primeNumbers.size();
        }

        public static void recursion(int positionNumber) {


            if (isPrimeNumber(positionNumber)) {
                primeNumbers.add(positionNumber);
            }



            for (int i = 0; i < iNumbers.length; i++) {
//                if( sCase.contains(String.valueOf(cNumbers[i]))){
//                    continue;
//                }
                if (usedNumbers[i]) {
                    continue;
                }
                int nextPostitionNumber = positionNumber * 10 + iNumbers[i];
                usedNumbers[i] = true;
                recursion(nextPostitionNumber);
                usedNumbers[i] = false;
            }
        }

        private static boolean isPrimeNumber(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static int solution_1(String numbers) {

            cNumbers = numbers.toCharArray();
            int length = cNumbers.length;
            primeNumbers = new HashSet<>();
            usedNumbers = new boolean[numbers.length()];

            recursion(0);
            return primeNumbers.size();
        }



        public static void recursion_1(String sCase) {

            if (!sCase.isEmpty()) {
                int number = Integer.parseInt(sCase);
                if (isPrimeNumber(number)) {
                    primeNumbers.add(number);
                }
            }


            for (int i = 0; i < cNumbers.length; i++) {
//                if( sCase.contains(String.valueOf(cNumbers[i]))){
//                    continue;
//                }
                if (usedNumbers[i]) {
                    continue;
                }
                sCase += cNumbers[i];
                usedNumbers[i] = true;
                recursion_1(sCase);
                usedNumbers[i] = false;
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
