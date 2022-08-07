/*
동전교환
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
▣ 입력설명
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종
류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
각 동전의 종류는 100원을 넘지 않는다.
▣ 출력설명
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
▣ 입력예제 1
3
1 2 5
15
▣ 출력예제 1
3
설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 */

function solution(n, array, m){

    let minCount = Number.MAX_SAFE_INTEGER;
    function dfs(L, sum){
        if (L > minCount) {
            return;
        }
        if (sum > m) {
            return;
        }

        if (sum === m) {
            minCount = Math.min(minCount, L);
            return;
        }

        for (let i = 0; i < n; i++) {
            dfs(L + 1, sum + array[i]);
        }
    }

    dfs(0, 0);
    return minCount;
}

console.log(solution(3, [1, 2, 5], 15));
console.log(solution(3, [5, 2, 1], 15));

/*

동전의 종류가 주어질 때 1 2 5로 크기순으로 주어질경우에는 역순으로 가장 큰 수의 동전부터 나누며 필요한 동전의 개수를 구할 수 있지만 크기가 작은 동전이 뒤에 나오는 등 랜덤하게 나오는 경우에는
가장 큰 동전이 언제 나올지 알 수 없으므로 모든 경우의 수를 다 구하고 그중에서 최소 개수를 선택하는 것이 필요합니다.
처음 동전이 나올 수 있는 경우의 수는 1,2,5 세가지가 있고 1이 나왔을 때 나올 수 있는 경우의 수는 1,2,5 계속 1만 나올 경우 최대 15번까지 탐색할 수 있습니다.
1 x 15 = 15. 0레벨부터 시작해서 1,2,5중 하나를 선택한 1레벨에서 다시 1,2,5를 선택한 2레벨로 다음에 나올 수 있는 경우의 수를 구하고 그 합을 계산해서 15원이 되면 종료합니다.
그래서 가장 많은 횟수가 나오는 경우는 1x15 이고 최소 횟수의 경우 5x3이 됩니다.
또한 15원이 되는 최소 개수를 저장하고 각 부분집합의 합이 최소 개수(Level)보다 더 작은 경우 최소 개수 minCount를 해당 값으로 바꿉니다.
 dfs(L, sum)에서 dfs(0,0)부터 시작해서 1,2,5를 선택했을 때 Level이 1인 경우에
 sum값 1,2,5는  dfs(1,1), dfs(1,2), dfs(1,5)로 표현할 수 있고 for(let i = 1; i <= n ; i++) dfs(L +1, sum + array[i]) 등으로 표현할 수 있습니다.
	- 부분집합 합이 15인 경우 종료. 합이 15를 넘는 경우도 종료
	- 부분집합 합의 원소 개수가 최소 원소 사용 개수를 넘어갈 경우 종료. 5x3 = 15. 3개를 넘어가는 부분집합이 나올 경우 더 탐색할 필요가 없습니다.
* */

function solutionBefore(n, array, m){

    let totalShare = 0;

    function dfs(remainder, index){
        if (index === -1) {
            console.log(totalShare);
            return;
        }

        if (remainder === 0) {
            console.log(totalShare);
            return;
        }
        let share = Math.floor(remainder / array[index]);
        console.log(remainder + " : " + array[index] + " : " + share);
        totalShare += share;
        dfs(remainder % array[index], index - 1);
    }

    dfs(m, n-1);
}

// solutionBefore(3, [1, 2, 5], 15);
// solutionBefore(3, [5, 2, 1], 15);
// solution(3, [1, 2, 5], 18);
// solution(3, [3, 5, 7], 18);

/*
입력예제1에서 동전의 종류 개수는 3(N), 동전의 종류 1 2 5 (array), 거슬러 줄 금액 15(M)이 주어졌을 때
5원 동전 3개가 거슬러줄 동전의 최소개수가 됩니다. 1원 15개, 1x5 +  2x5 = 15 등이 있습니다.
15 / 5 = 3 . 18원이라고 할 경우 18/5 = 3, 3 / 2 = 1, 1 / 1 = 1 나머지 0
dfs(18, index : 2);  18 / array[2] 가장 값이 큰 동전으로 우선 나누고 share에 몫을 더해줍니다.
18 / 5 = 3, share += 3, dfs(3, index : 1) 3 / array[1] = 1, share += 1; dfs(1, index : 0);
 share += 1; dfs(0, index : -1). dfs(remainder, index)에서 index가 -1이 되거나 remainder가 0이 되는 경우 return합니다.
 */


function solutionRef(m, arr){
    let answer=Number.MAX_SAFE_INTEGER;
    let n=arr.length;
    function DFS(L, sum){
        if(sum>m) return;
        if(L>=answer) return;
        if(sum===m){
            answer=Math.min(answer, L);
        }
        else{
            for(let i=0; i<n; i++){
                DFS(L+1, sum+arr[i]);
            }
        }
    }
    DFS(0, 0);
    return answer;
}

let arr=[1, 2, 5];
// console.log(solutionRef(15, arr));