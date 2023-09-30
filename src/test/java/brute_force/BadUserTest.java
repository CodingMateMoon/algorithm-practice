package brute_force;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
        /* frodo, crodo, abc123, frodoc | fradi, crodo, abc123, frodoc | fradi, frodo, abc123, frodoc
        fr*d*-> frodo, fradi
        *rodo-> frodo, crodo
        ******-> abc123, frodoc
         */
        Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})).isEqualTo(3);
    }

    private static class BadUser {

        static boolean[] isBannedIdSelected;

        static Set<Set<String>> result;

        public static int solution(String[] userIds, String[] bannedIds) {

            boolean[] isUserIdSelected = new boolean[userIds.length];
            isBannedIdSelected = new boolean[bannedIds.length];
            result = new HashSet<>();


            getBadUser(userIds, bannedIds, isUserIdSelected, new HashSet<>());
            return result.size();
        }

        private static void getBadUser(String[] userIds, String[] bannedIds, boolean[] isUserIdSelected, Set<String> badUsers) {

             /*
             Assertions.assertThat(BadUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
             case 2: frodo, crodo, abc123 | frodo, crodo, frodoc
             *rodo-> frodo, crodo
             *rodo-> frodo, crodo
             ******-> abc123, frodoc
             1 : 응모자 아이디 목록에서 불량사용자1과 매핑되는 요소 1개 선택. 응모자 아이디 isSelected = true. getBadUser 재귀호출.
             2 : 1번에서 제외하고 남은 응모자 아이디 목록 중 불량사용자2와 매핑되는 요소 1개 선택
             3 : 1,2에서 제외하고 남은 응모자 아이디 목록 중 불량사용자3과 매핑되는 요소 1개 선택
             => 재귀 for문 활용 고려
             비트 연산 경우의 수 구하기?
             10110(frodo:true, crodo:true, abc123:true)
             10101(frodo:true, crodo:true, frodoc:true)
             불량사용자 기준 1,2,3 ~ 다 true일 때 print. 불량 사용자는 순차적으로 다 매핑되는 응모자 아이디가 있어야 합니다. 불량사용자 1 -> 응모자 아이디 1, 2, 3 재귀 호출 및 백트래킹. 다 돌고나서 매핑된 경우가 없으면 return. 불량 사용자 1은 매핑이 없는데 불량 사용자 2에서 매핑되는 경우를 막아야 합니다.
             */

            if (badUsers.size() == bannedIds.length) {
                result.add(new HashSet<>(badUsers));
                return;
            }


            for (int bannedIdOffset = 0; bannedIdOffset < bannedIds.length; bannedIdOffset++) {
                if (isBannedIdSelected[bannedIdOffset]) {
                    continue;
                }


                boolean isMapping = false;
                for (int userIdOffset = 0; userIdOffset < userIds.length; userIdOffset++) {
                    if (isUserIdSelected[userIdOffset]) {
                        continue;
                    }

                    if (bannedIds[bannedIdOffset].length() != userIds[userIdOffset].length())
                        continue;

                    char[] charBannedId = bannedIds[bannedIdOffset].toCharArray();
                    char[] charUserId = userIds[userIdOffset].toCharArray();

                    boolean isSame = true;
                    for (int charBannedIdOffset = 0; charBannedIdOffset < charBannedId.length; charBannedIdOffset++) {

                        if(charBannedId[charBannedIdOffset] == '*')
                            continue;

                        if (charBannedId[charBannedIdOffset] != charUserId[charBannedIdOffset]) {
                            isSame = false;
                        }
                    }

                    if (isSame) {
                        isBannedIdSelected[bannedIdOffset] = true;
                        isUserIdSelected[userIdOffset] = true;
                        badUsers.add(userIds[userIdOffset]);

                        getBadUser(userIds, bannedIds, isUserIdSelected, badUsers);
                        isBannedIdSelected[bannedIdOffset] = false;
                        isMapping = false;
                        badUsers.remove(userIds[userIdOffset]);
                        isUserIdSelected[userIdOffset] = false;
                    }
                }
                if (!isMapping) {
                    return;
                }

            }
        }


    }
}
