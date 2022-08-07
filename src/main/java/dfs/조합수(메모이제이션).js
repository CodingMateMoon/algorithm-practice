/*
조합 구하기
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그
램을 작성하세요.
▣ 입력설명
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
▣ 출력설명
첫 번째 줄에 결과를 출력합니다. 맨 마지막 총 경우의 수를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.
▣ 입력예제 1
4 2
▣ 출력예제 1
1 2
1 3
1 4
2 3
2 4
3 4
6
 */

function solution(n, m){

    let answer = [];
    let resultArray = Array.from({length: m}, () => 0);
    function dfs(level, start){

        if (level === m) {

            answer.push(resultArray.slice());
            return;
        }

        for (let i = start; i <= n ; i++) {

            resultArray[level] = i;
            dfs(level + 1, i +1);
        }
    }

    dfs(0, 1);
    return answer;
}

console.log(solution(4, 2));

/*
자연수 1~N중에서 M개를 뽑는 경우의 수를 구합니다. 1 2와 2 1은 같은 경우의 수이므로 Level = 0 에서 2를 뽑았을 경우에는 그 이전의 수인 1을 제외해야합니다.  N = 4, M = 2인 경우를 기준으로 했을 때
dfs(level, start)로 함수를 호출해서 dfs(0, 1) 부터 시작하고 for(let i = 1; i <=n; i++) 일때
i= 1일 경우 resultArray[0] = 1 => resultArray[L] = i; 로 나타낼 수 있고 dfs(0 + 1, i + 1) 즉 dfs(1, 2)를 호출합니다.
이때 for(let i = start; i <=n; i++)로 나타낼 수 있는데 1을 이미 선택한 상태여서 start = 2이므로 i = 2부터 시작합니다. i = 2일 경우 resultArray[1] = 2 이고 dfs(1+1, 2+1) = dfs(2,3)을 호출합니다. 이때 m = 2 개를 뽑는 경우를 구하고 있으므로 L == m일때 정답을 저장하고 종료시킵니다. dfs(2,3)이 종료되면 다시 dfs(1,2)로 돌아가서 i=3인 경우 resultArray[1]= 3 이고 dfs(1+1, 3 +1) = dfs(2,4)를 호출합니다. answer에 [1,3] 을 저장하고 return한 후에 다시 dfs(1,2)로 돌아가서 i=4인 경우를 구합니다.
 */


function solutionBefore(n, m){

    let array = Array.from({length: n+1}, () => 0);
    let check = Array.from({length: n+1}, () => false);
    let combinationResult = Array.from(Array(n + 1), ()=>new Array(m + 1).fill(0));
    let answer = Array.from({length: m + 1}, () => 0);
    let count = 0;

    function dfs(L){

        if (L === m+1) {
            let result = "";
            for (let i = 1; i <= m; i++) {
                // if(check[i])
                    result += answer[i] + " ";
            }
            count++;
            console.log(result);
            return;
        }

        for (let i = 1; i <= n; i++) {
            // console.log(L + " : " + i + " : " + check+ " : " + answer) ;
            if(check[i] || (L != 1 && answer[L -1] >= i) )
                continue;
            check[i] = true;
            answer[L] = i;
            // console.log(answer);
            dfs(L + 1);
            check[i] = false;
        }
    }

    dfs(1);
    return count;
}

// console.log(solutionBefore(4, 2));
// console.log(solutionBefore(5, 3));

/*
N개 중에 M개를 뽑는 경우 4개중에 2개를 뽑는 경우를 구하면 처음에 올 수 있는 경우 4가지 그 다음 경우 3가지가 있는데 순서가 상관없으므로 순서에 대한 경우를 제외해서 /2를 하면 4 * 3 / 2 = 6 이 나옵니다. 각 경우의 수를 사전순으로 출력하는 것이 필요합니다.  N C M = N - 1 C M -1 + N-1 C M 으로 나타낼 수 있고
1 C 1 , 2 C 2 와 같이 N == M 인 경우 , 1 C 0, 2 C 0과 같이 M이 0인 경우 1을 return합니다. 4 C 2 = 3 C 1 + 3C2 등 각 조합의 결과값을 combinationResult[N][M]에 저장합니다. 1을 선택한 경우 2 3 4가 나올 수 있고 2를 선택한 경우 2 1, 2 3 , 2 4 가 나올 수 있지만 2 1 은 앞에서 1 2로 나왔기 때문에 제외합니다  인덱스 1 2 3 4 등이 있다고 할 때 1 2 , 2 3 과 같이 먼저 뽑은 인덱스 다음에는 그보다 큰 인덱스만 선택이 가능하도록 예외처리를 합니다. array[i] , array[j] 순으로 뽑을 때 i < j 인 경우만 구합니다. array[2] array[3]에 체크가 되었을 때 의도한 값은 3 2 이지만 2 3이 출력될 수 있습니다. 레벨에 맞는 결과값 저장이 필요합니다.

 */


function solutionRef(n, m){
    let answer=[];
    let tmp=Array.from({length:m}, ()=>0);;
    function DFS(L, s){
        if(L===m){
            answer.push(tmp.slice());
        }
        else{
            for(let i=s; i<=n; i++){
                tmp[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    DFS(0, 1);
    return answer;
}

// console.log(solutionRef(4, 2));

/*
 D(Level, start) 로 함수를 호출해서 D(0,1) 1 뽑았으면 2 3 4 D(1,2) 2 뽑은 경우 3, 4의 경우의 수가 남습니다. 

s = 1부터 시작합니다.
for(let i = s; i <=n; i++) {

}
 */