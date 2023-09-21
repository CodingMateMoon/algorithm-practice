package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadUserTest {

    // https://school.programmers.co.kr/learn/courses/30/lessons/64064
    /*
    1 <= user_id length <= 8
    1 <= user_id[i] : 중복X, 소문자, 숫자로만 구성 <= 8
    1 <= banned_id.length <= user_id.length
    1 <= banned_id[i] : 소문자, 숫자, *로 구성. 최소 * 1개 이상, 응모자 아이디 1개와 매핑. 중복 매핑 X <= 8
    제재 아이디 목록 조합(나열 순서 상관X)

     */
    @Test
    @DisplayName("BadUserTest")
    public void badUserTest() throws Exception{
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})).isEqualTo(2);
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})).isEqualTo(3);
    }

    private static class BadUser {
        public static int solution(String[] user_id, String[] banned_id) {
            return 0;
        }
    }
}
