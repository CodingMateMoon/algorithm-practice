/*
수열 추측하기
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼
의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다. 예를 들어 N이 4 이고 가장 윗 줄에 3
1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
3 1 2 4
4 3 6
7 9
16
N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하
시오. 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
▣ 입력설명
첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다. N은 가장 윗줄에 있는 숫자의 개수를 의
미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
▣ 출력설명
첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다. 답이 존재
하지 않는 경우는 입력으로 주어지지 않는다.
▣ 입력예제 1
4 16
▣ 출력예제 1
3 1 2 4
 */

function solution(n, f){

    let combinationValue = Array.from(new Array(11), () => new Array(11).fill(0));
    let check = Array.from(new Array(11), () => false);
    let resultArray = Array.from({length: 10}, () => 0);
    let levelCombinationValue = Array.from({length: 10}, () => 0);
    let flag = false;
    let answer = [];
    console.log("check : " + check);

    function combination(n, r){
        if (combinationValue[n][r] > 0) {
            return combinationValue[n][r];
        }
        if (n === r || r === 0) {
            return 1;
        }
        // console.log(n + " : " + r);
        combinationValue[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        return combinationValue[n][r];
    }

    function dfs(L, sum){
        if(flag)
            return;

        if (L === n) {
            // console.log(resultArray);
            if(sum === f) {
                console.log("------answer-----");
                console.log(resultArray);
                answer.push(resultArray.slice());
                flag = true;
            }
            return;
        }
        // console.log("테스트"  + " : " + L + " : " + sum);
        // console.log(resultArray);
        // console.log("----------------------")

        if (sum > f) {
            // console.log("sum > f------")
            // console.log(resultArray);
            return;
        }
        for (let i = 1; i <= n ; i++) {
            if(check[i])
                continue;
            console.log(L + " : " + i + " : " + sum);
            console.log(resultArray);
            check[i] = true;
            resultArray[L] = i;
            console.log("after sum : " + sum);
            dfs(L + 1, sum + i * levelCombinationValue[L]);
            check[i] = false;
            resultArray[L] = 0;


        }
    }

    for (let i = 0; i < n; i++) {
        levelCombinationValue[i] = combination(n - 1, i);
    }
    console.log(levelCombinationValue)

    dfs( 0, 0);
     return answer;
}

console.log(solution(4, 16));

/*
N =4 /  1, 2, 3, 4 까지의 수가 있고 3 1 2 4 로 예를 들면  3 +1 = 4 이고 1 + 2 = 3  2 +4 = 6 입니다.
3 + 1 + 1 + 2 = 7 , 1 + 2 +2 + 4 = 9 가 나오고  3 + 1 + 1 + 2 + 1 + 2 + 2 + 4 = 16 입니다. 결과적으로 16은 3 x 1 + 1 x 3 + 2 x 3 + 4 x 1 = 16 입니다. 조합의 경우로 봤을 때 3C0 3C1 3C2 3C3 인 것을 알 수 있습니다. 가장 윗줄의 숫자 N = 4 / 1 2 3 4 에 대해 중복하지 않고 나열할 수 있는 경우는 4 x 3 x 2 x 1 등이 있습니다. 각각의 나열한 경우들 1 2 3 4 / 3 1 2 4 들에 대해 3C0 3C1 3C2 3C3 등으로 선택했을 때 합이 16이 되는 경우를 찾습니다. 나열하는 경우들에 대해서는 check 배열을 통해 사용된경우 제외하고 사용하지 않은 경우에는 사용하면서 체크하고 관리합니다. for문을 활용해서 1부터 N까지 각각의 수를 선택했을 때 경우를 구합니다. for(let i = 1; i <= N; i++) 1부터 N까지 나열할 수 있는 경우의 수를 구합니다. n-1 C r 에 대해서 n-1 C 0 부터 n-1 C n-1까지의 수를 구하고 이것을 각각 나열한 경우의 수와 곱한 합이 F가 나오는 경우를 구해야합니다. Level = 1, i = 3 체크 sum 합계에 더할 값은 i (3) * 3C0 (1) = 3 . dfs(L+1, sum + i * combination(n-1, i-1)) 이때 Level === N (4)가 되면 종료합니다. 곱한 합 sum이 F보다 클 경우 return합니다.

	1. check배열 관리 let check = Array.from({length : N}, ()=> false);
for(let i = 1; i <= N; i++)  dfs(L+1,  sum + i * combination(n, i-1)) 등 나열할 수 있는 경우의 수를 구하고 각각에 조합의 경우의 수 n-1 C i-1  을 곱해줍니다. 이때 i를 사용한 경우 다음번 재귀에서 i를 재사용하는 일이 없도록 체크해줍니다.
 */

/* Before

가장 윗줄에 있는 숫자의 개수 N : 4,  가장 밑에 줄에 있는 수 F : 16 이고 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장된다고 할 때 가장 밑에 줄에 있는 수부터 시작해서 16, 7 9 , 4 3 6, 3 1 2 4 와 같이 두 개를 더한 값이 아래쪽의 수와 같은 경우의 수를 구합니다.
가장 밑에줄에 있는 수가 16일때를 기준으로 1, 15 / 2 14 / 3 13 / 4 16 등이 있고
1 15의 경우 두 개의 정수로 더해서 1이 될 수 없으므로 더 이상 구할 수 있는 경우가 존재하지 않습니다.  2 14 역시 마찬가지입니다. 3 13의 경우  3의 경우는 1 2 , 13의 경우는 1 12 / 2 11 등으로 나누어질 수 있습니다.
Level이 1부터 시작해서 N = 4 가 되었을 때까지 1 이상의 정수로 구성된 수가 나올 경우 종료합니다.
dfs(1, 16) = dfs(L, F) = dfs(L-1, x) + dfs(L-1, F - x) [ 1 <= x <= F - 1 ]
답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 하므로 F = 16일때 7 9 / 9 7 이 있는 경우 7 9가 우선적으로 선택됩니다. 따라서 x <= y로 설정하고 x == y 일 경우 모든 경우의 수를 구했다고 판단할 수 있습니다. 1, 15 / 2, 14와 같이 1 또는 2가 나오는 경우 두 수의 합이 1, 2가 될 수 없고 더이상 구할 수 없으므로 종료합니다.  if( x <= 2) return; if (x <= 2 && L === N) 인 경우 답을 만족시키므로 해당 값을 출력합니다. dfs(1,16) =  dfs(2,7) + dfs(2,9) = dfs(3,4) + dfs(3,3)  + dfs(3, 6) = dfs(4, 3) + dfs(4, 1) + dfs(4,2) + dfs(4,4)
dy[x][y] 에 부분 결과값들을 저장하는데 1<= x <= 500000, 1 <= y <= 1000000 입니다.
dfs(1, 1) , dy[1][1] / dfs(2, 1) = dy[2][1], dfs(2, 2) = dy[2][2]
dy[1][1] = dy[2][1] + dy[2][2]

 */

function solutionRef(n, f){
    let answer, flag=0;
    let dy= Array.from(Array(11), () => Array(11).fill(0));
    let ch=Array.from({length:n+1}, ()=>0);
    let p=Array.from({length:n}, ()=>0);
    let b=Array.from({length:n}, ()=>0);
    function combi(n, r){
        if(dy[n][r]>0) return dy[n][r];
        if(n===r || r===0) return 1;
        else return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
    }
    function DFS(L, sum){
        if(flag) return;
        if(L===n && sum===f){
            answer=p.slice();
            flag=1;
        }
        else{
            for(let i=1; i<=n; i++){
                if(ch[i]===0){
                    ch[i]=1;
                    p[L]=i;
                    DFS(L+1, sum+(b[L]*p[L]));
                    ch[i]=0;
                }
            }
        }
    }
    for(let i=0; i<n; i++){
        b[i]=combi(n-1, i);
    }
    DFS(0, 0);
    return answer;
}

//console.log(solutionRef(4, 16));