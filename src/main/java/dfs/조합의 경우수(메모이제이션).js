/*

조합의 경우수(메모이제이션)
nCr = n! / (n-r)!r! 로 계산합니다. 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여
재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
nCr = n-1 C r-1 + n-1 C r
▣ 입력설명
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
▣ 출력설명
첫째 줄에 조합수를 출력합니다.
▣ 입력예제 1
5 3
▣ 출력예제 1
10
▣ 입력예제 2
33 19
▣ 출력예제 2
818809200


* */

function solution(n, r){

    let dy = Array.from(Array(34), () => Array(34).fill(0));
    function dfs(n, r){

        if (n === r || r === 0)
            return 1;
        return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }

    return dfs(n, r);
}

console.log(solution(5, 3));


function solutionBefore(n, r){
    if (n === r)
        return 1;

    if (n === 1 || r === 0)
        return 1;

    return solutionBefore(n - 1, r - 1) + solutionBefore(n - 1, r);
}

// console.log(solution(5, 3));
//console.log(solution(33, 19));

function solutionRef(n, r){
    let answer=[];
    let dy= Array.from(Array(35), () => Array(35).fill(0));

    function DFS(n, r){
        if(dy[n][r]>0) return dy[n][r];
        if(n===r || r===0) return 1;
        else return dy[n][r]=DFS(n-1, r-1)+DFS(n-1, r);
    }
    answer=DFS(n, r);
    return answer;
}

// console.log(solutionRef(5, 3));
// console.log(solutionRef(33, 19));