/*
재귀함수를 이용한 이진수 출력
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용
해서 출력해야 합니다.
▣ 입력설명
첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
▣ 출력설명
첫 번째 줄에 이진수를 출력하세요.
▣ 입력예제 1
11
▣ 출력예제 1
1011
 */
function solution(n) {

    let answer = "";
    function recursive(n) {

        if (n === 0) {
            return;
        }
        let mok = Math.floor(n / 2);
        recursive(mok);
        console.log(String(Math.floor(n % 2)));
        answer += String(n % 2);
    }

    recursive(n);
    return answer;
}

console.log(solution(11));
console.log(solution(10));

/*
11이 입력될 경우 11/2 = 5, 1 | 5/2 = 2, 1 | 2/2 = 1, 0 | 1/2 = 0, 1 결과적으로 1011(2) 값이 나옵니다. 11를 2로 나눈 몫이 0이 되면 그동안 나왔던 나머지들을
마지막에서부터 순차적으로 출력합니다. 10이 입력되는 경우를 다른 예로 들면 10/2 = 5, 0 | 5/2 = 2, 1 | 2/2 = 1, 0 | 1/2 = 0, 1 입니다. 나머지들을 마지막에서 부터
순차적으로 나열하면 1010(2)이 됩니다. 이를 재귀함수로 표현할 경우 n / 2 = n/2, n%2 | (n/2) / 2 = (n/2)/2, (n/2) % 2 ...  n / 2^x, n / 2^(x-1) %2 입니다.
이때 몫이 0이 되면 마지막에서부터 나머지 값을 출력합니다. 1/2 = 몫 0, 나머지 1 |
* */

function solutionRef(n){
    let answer="";
    function DFS(n){
        if(n===0) return;
        else{
            DFS(parseInt(n/2));
            answer+=String(n%2);
        }
    }
    DFS(n);
    return answer;
}

console.log(solutionRef(11));