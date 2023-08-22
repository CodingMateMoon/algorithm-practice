package recursive_function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionaryTest {
    /*
    A, E, I, O, U 를 이용하여 길이 5이하인 단어를 구성할 때 A, AA, AAA ...부터 시작해서 AE, AI, AO, AU 등으로 끝날 수 있습니다.
    1, 2, 3, 4, 5.  1, 11, 111, ...
     12 13 14 15
    (length)
    11115 - 6
    1112 - 7
    1113 - 8
    1114 - 9
    1115 - 10
    (word)
    if (word.length >= 5) return
    word + A, word + E, word + I, word + O, word + U
     */
    @Test
    @DisplayName("모음사전")
    void getWordSequence() {
        Assertions.assertThat(VowelDictionary.solution("AAAAE")).isEqualTo(6);
        Assertions.assertThat(VowelDictionary.solution("AAAE")).isEqualTo(10);
        Assertions.assertThat(VowelDictionary.solution("I")).isEqualTo(1563);
        Assertions.assertThat(VowelDictionary.solution("EIO")).isEqualTo(1189);
    }

    private static class VowelDictionary {

        static final char[] vowels = {'A', 'E', 'I', 'O', 'U'};

        public static int solution(String word) {
            List<String> words = new ArrayList<>();
            getWords("", words);
            return words.indexOf(word);
        }

        private static void getWords(String word, List<String> words) {
            words.add(word);
            if (word.length() >= 5) {
                return;
            }
            for (char c : vowels) {
                getWords(word + c, words);
            }
        }
    }
}
