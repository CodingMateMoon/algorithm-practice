/*
팩토리얼
자연수 N을 입력하면 N!값을 구하세요.
N! = n*(n-1)*(n-2)*.....*2*1입니다.
만약 N=5라면 5!=5*4*3*2*1=120입니다.
▣ 입력설명
첫째 줄에 자연수 N(3<=n<=10)이 입력됩니다.
▣ 출력설명
첫째 줄에 N팩토리얼 값을 출력합니다.
▣ 입력예제 1
5
▣ 출력예제 1
120
 */

function solution(n){

    let answer = 1;
    function dfs(number){
        if (number === 1) {

            return;
        }

        answer *= number;
        dfs(number - 1);

    }

    dfs(n);
    return answer;
}

console.log(solution(5));

function solutionBefore(n){
    let answer = 1;
    for (let i = n; i >=  1; i--) {

        answer *= i;
    }
    return answer;
}

// console.log(solutionBefore(5));


function solutionRef(n){
    let answer;
    function DFS(n){
        if(n===1) return 1;
        else return n*DFS(n-1);
    }
    answer=DFS(n);
    return answer;
}

// console.log(solutionRef(5));