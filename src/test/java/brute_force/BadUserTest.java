package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BadUserTest {

    // https://school.programmers.co.kr/learn/courses/30/lessons/64064
    /*
    1 <= user_id length <= 8
    1 <= user_id[i] : 중복X, 소문자, 숫자로만 구성 <= 8
    1 <= banned_id.length <= user_id.length
    1 <= banned_id[i] : 소문자, 숫자, *로 구성. 최소 * 1개 이상, 응모자 아이디 1개와 매핑. 중복 매핑 X <= 8
    제재 아이디 목록 조합(나열 순서 상관X)
    user_id와 banned_id를 비교할 때 *는 continue, 각 자리수와 문자가 일치하는 경우를 찾습니다

     */
    @Test
    @DisplayName("BadUserTest")
    public void badUserTest() throws Exception{
        /* frodo, abc123 | fradi, abc123
        fr*d* -> frodo, fradi
        abc1** -> abc123
         */
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})).isEqualTo(2);
        /* case 2: frodo, crodo, abc123 | frodo, crodo, frodoc
         *rodo-> frodo, crodo
         *rodo-> frodo, crodo
         ******-> abc123, frodoc
         1 : 응모자 아이디 목록에서 불량사용자1과 매핑되는 요소 1개 선택. 응모자 아이디 isSelected = true
         2 : 1번에서 제외하고 남은 응모자 아이디 목록 중 불량사용자2와 매핑되는 요소 1개 선택
         3 : 1,2에서 제외하고 남은 응모자 아이디 목록 중 불량사용자3과 매핑되는 요소 1개 선택
         => 재귀 for문 활용 고려
         비트 연산 경우의 수 구하기?
         10110(frodo:true, crodo:true, abc123:true)
         10101(frodo:true, crodo:true, frodoc:true)
         불량사용자 기준 1,2,3 ~ 다 true일 때 print
         */
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
        /* frodo, crodo, abc123, frodoc | fradi, crodo, abc123, frodoc | fradi, frodo, abc123, frodoc
        fr*d*-> frodo, fradi
        *rodo-> frodo, crodo
        ******-> abc123, frodoc
         */
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})).isEqualTo(3);
    }

    private static class BadUser {

        static Boolean[] isBannedIdSelected;

        public static int solution(String[] userIds, String[] bannedIds) {

            Boolean[] isSelected = new Boolean[userIds.length];
            isBannedIdSelected = new Boolean[bannedIds.length];

            List<String> badUsers = getBadUser(userIds, bannedIds, isSelected, new ArrayList<String>());
            return 0;
        }

        private static List<String> getBadUser(String[] userIds, String[] bannedIds, Boolean[] isSelected, List<String> badUsers) {

             /*
             Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
             case 2: frodo, crodo, abc123 | frodo, crodo, frodoc
             *rodo-> frodo, crodo
             *rodo-> frodo, crodo
             ******-> abc123, frodoc
             1 : 응모자 아이디 목록에서 불량사용자1과 매핑되는 요소 1개 선택. 응모자 아이디 isSelected = true
             2 : 1번에서 제외하고 남은 응모자 아이디 목록 중 불량사용자2와 매핑되는 요소 1개 선택
             3 : 1,2에서 제외하고 남은 응모자 아이디 목록 중 불량사용자3과 매핑되는 요소 1개 선택
             => 재귀 for문 활용 고려
             비트 연산 경우의 수 구하기?
             10110(frodo:true, crodo:true, abc123:true)
             10101(frodo:true, crodo:true, frodoc:true)
             불량사용자 기준 1,2,3 ~ 다 true일 때 print
             */
            for (int bannedIdOffset = 0; bannedIdOffset < bannedIds.length; bannedIdOffset++) {

                for (int userIdOffset = 0; userIdOffset < userIds.length; userIdOffset++) {
                    char[] charBannedId = bannedIds[userIdOffset].toCharArray();
                    char[] charUserId = userIds[userIdOffset].toCharArray();
                }
            }

            for (int userIdOffset = 0; userIdOffset < userIds.length; userIdOffset++) {
                if (isSelected[userIdOffset]) {
                    continue;
                }
                char[] charUserId = userIds[userIdOffset].toCharArray();
                char[] charBannedId = bannedIds[userIdOffset].toCharArray();
                boolean isBadUser = true;
                for (int cUserIdOffset = 0; cUserIdOffset < charUserId.length; cUserIdOffset++) {
                    if (charUserId[cUserIdOffset] != charBannedId[cUserIdOffset]) {
                        isBadUser = false;
                        break;
                    }
                }
                if (isBadUser) {
                    badUsers.add(userIds[userIdOffset]);
                    isSelected[userIdOffset] = true;
                }
            }

            return null;
        }
    }
}
