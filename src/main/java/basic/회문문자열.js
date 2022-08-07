/*
회문 문자열
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.
▣ 입력설명
첫 줄에 정수 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
▣ 출력설명
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
▣ 입력예제 1
gooG
▣ 출력예제 1
YES
 */

function checkString(s) {
    let answer = "YES";
    var upS = s.toUpperCase();
    var middle = Math.ceil(upS.length / 2);
    var length = s.length;
    for(var i = 0; i < length; i++ ) {
        console.log(`${upS.charAt(i) } : ${upS.charAt(length - i - 1) }`)
        if (upS.charAt(i) !== upS.charAt(length - i - 1)) {
            answer = "NO";
            return answer;
        }
    }
    return answer;
}

console.log(checkString("gooG"));
console.log(checkString("abooba"));
/*
문자열의 대소문자 구분을 없애기 위해서 전부 대문자로 바꾼후에 가장 앞의 요소와 뒤의 요소부터 시작해서 순차적으로 비교하고 같은지 확인합니다.
문자열이 2자리인 경우 0,1 [ length /2 = 2 /2 = 1 ] . 3자리인 경우 0,2 [ 3/2 = 1]. 4자리인 경우 (0,3), (1,2 [4/2 = 2]. 5자리인 경우 (0, 4), (1,3) [ 5/2 = 2] 순으로 비교합니다.
첫번째 요소와 마지막 요소가 같고, 두번째 요소와 마지막 요소-1, 세번째 요소와 마지막 요소 - 2 => (length /2)까지 수행합니다.
하나라도 다른 것이 있으면 NO를 입력하고 break.
* */