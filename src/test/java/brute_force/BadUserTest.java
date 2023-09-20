package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadUserTest {

    // https://school.programmers.co.kr/learn/courses/30/lessons/64064
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
