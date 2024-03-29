package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NewIdRecommendationTest {

    /*
    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     */
    @Test
    @DisplayName("신규 아이디 추천")
    void 신규_아이디_추천() {
        // given
        Assertions.assertThat(NewIdRecommendation.solution("...!@BaT#*..y.abcdefghijklm")).isEqualTo("bat.y.abcdefghi");
        Assertions.assertThat(NewIdRecommendation.solution("z-+.^.")).isEqualTo("z--");
        Assertions.assertThat(NewIdRecommendation.solution("=.=")).isEqualTo("aaa");
        Assertions.assertThat(NewIdRecommendation.solution("123_.def")).isEqualTo("123_.def");
        Assertions.assertThat(NewIdRecommendation.solution("abcdefghijklmn.p")).isEqualTo("abcdefghijklmn");
        // expected
    }

    class NewIdRecommendation {

        public static String solution(String newId) {

            String answer = new Id(newId).toLowerCase()
                    .removeSpecificCharacter()
                    .replacePeriodAsOne()
                    .removeFirstOrLastPeriod()
                    .replaceEmptyToA()
                    .notGreaterThan16()
                    .greaterThan2();

            return answer;
        }

        static class Id{

            private String id;
            public Id(String newId) {
                this.id = newId;
            }

            public Id toLowerCase() {
                this.id = this.id.toLowerCase();
                return this;
            }

            public Id removeSpecificCharacter() {

                this.id = this.id.replaceAll("[^a-z0-9_.-]", "");
//                this.id = this.id.replaceAll("[^a-z0-9\\-_.]", "");
                return this;

            }

            public Id replacePeriodAsOne() {
//                this.id = this.id.replaceAll("\\.{2,}", ".");
                this.id = this.id.replaceAll("[.]{2,}", ".");
                return this;
            }

            public Id removeFirstOrLastPeriod() {
//                this.id = this.id.replaceAll("^\\.|\\.$", "");
                this.id = this.id.replaceAll("^[.]|[.]$", "");
                return this;
            }

            public Id replaceEmptyToA() {
                /*if (this.id.isEmpty()) {
                    this.id = "a";
                }*/
                this.id = this.id.isEmpty() ? "a" : this.id;
                return this;
            }

            public Id notGreaterThan16() {
                if (16 <= this.id.length()) {
                    this.id = this.id.substring(0, 15).replaceAll("\\.$", "");
                }
                return this;
            }

            public String greaterThan2() {
                while (this.id.length() <= 2) {
                    this.id += this.id.charAt(this.id.length() - 1);
                }
                return this.id;
            }
        }


        public static String solution_1(String newId) {
            StringBuilder sb = new StringBuilder();

            for (char c : newId.toCharArray()) {
                if ('A' <= c && c <= 'Z') {
                    c = (char) (c + ('a' - 'A'));
                    sb.append(c);
                    continue;
                }

                if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                    sb.append(c);
                }
            }

            newId = sb.toString();
            sb.setLength(0);
            boolean isPeriod = false;
            for (char c : newId.toCharArray()) {
                if (c == '.') {
                    if (isPeriod) {
                        continue;
                    }
                    isPeriod = true;
                    sb.append(c);
                    continue;
                }
                isPeriod = false;
                sb.append(c);
            }

            newId = sb.toString();
            if (newId != null && newId.length() > 0 && newId.charAt(0) == '.') {
                newId = newId.substring(1);
            }
            if (newId != null && newId.length() > 0 && newId.charAt(newId.length() - 1) == '.') {
                newId = newId.substring(0, newId.length() - 1);
            }
            if (newId == null || newId.length() == 0) {
                newId = "a";
            }

            if (newId.length() >= 16) {
                newId = newId.substring(0, 15);
                if (newId.charAt(newId.length() - 1) == '.') {
                    newId = newId.substring(0, newId.length() - 1);
                }
            }

            if (newId.length() <= 2) {
                sb = new StringBuilder(newId);
                char c = newId.charAt(newId.length() - 1);
                while (sb.length() < 3) {
                    sb.append(c);
                }

                newId = sb.toString();
            }

            return newId;
        }
    }
}