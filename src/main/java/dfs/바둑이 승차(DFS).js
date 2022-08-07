/*
바둑이 승차(DFS)
철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태
울수가 없다. 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운
무게를 구하는 프로그램을 작성하세요.
▣ 입력설명
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
둘째 줄부터 N마리 바둑이의 무게가 주어진다.
▣ 출력설명
첫 번째 줄에 가장 무거운 무게를 출력한다.
▣ 입력예제 1
259 5
81
58
42
33
61
▣ 출력예제 1
242
 */

function solution(c, n, array){

    let max = 0;
    function dfs(L, sum){
        if (sum > c) {
            return;
        }
        if(L > n - 1) {
            console.log(max + " : " + sum);
            if(max < sum)
                max = sum;
            return;
        }
        dfs(L + 1, sum + array[L]);
        dfs(L + 1, sum);
    }

    dfs(0, 0);
    //console.log("max : " + max);
    return max;
}

//console.log(solution(259, 5, [81, 58, 42, 33, 61]));

/*
	- 예제1에서 259킬로그램(C) 5마리(N)이 첫번째 줄에 먼저 주어지고 각 바둑이의 무게 81 58 42 33 61이 주어졌을 때 각 부분집합중에서 259을 넘지않는 최대합은 242인 것으로 계산하고 출력하고 있습니다.
	 각 부분집합의 합이 C를 넘지않는 최대값을 구합니다.
	 먼저 부분집합의 경우의 수를 구하고 최대값 max 변수에 해당 합을 저장한뒤에 다음 부분집합의 합과 max 변수에 저장된 값을 비교해서 값이 클 경우 변경해줍니다.
	  모든 부분집합의 경우의 수 탐색이 끝난 후 max 변수를 출력합니다.
	  부분집합의 경우의 수는 Level 0부터 시작해서 0을 포함하는 경우 dfs(L + 1, sum + array[L]); dfs(L+1, sum)으로 호출하고 Level > n-1일때 함수를 종료시킵니다. (0 ~ n-1 총 n개)
	  	d1일때 81, d2 : 81 + 58 = 139 , d3 = 81 + 58 + 42 = 181 , d4 = 81 + 58 + 42 + 33 = 214 , d5 = 81 + 58 + 42 + 33 + 61 = 275
    259를 초과하므로 return 합니다. dfs(5,  sum[214] + 61); 호출했던 지점으로 되돌아가서 다음 명령어인 dfs(5, sum)을 호출합니다.
    L > 4 에서 L이 4를 초과하므로 max값과 비교한 후 max에 214를 넣어줍니다. dfs(4, sum[181] + 33)을 호출했던 지점으로 되돌아가서 dfs(4, sum[81+58+42 = 181])를 호출합니다.
    dfs(5, sum[181] + 61)을 호출합니다.
    L > 4 이므로 sum(181 + 61 = 242)값과 max값을 비교한 후 max에 242를 넣어주고 return합니다. dfs(5, sum[181] + 61)을 호출한 곳으로 돌아가서 dfs(5, sum[181])을 호출합니다.
 */

function solutionRef(c, arr){
    let answer=Number.MIN_SAFE_INTEGER;
    let n=arr.length;
    function DFS(L, sum){
        if(sum>c) return;
        if(L===n){
            answer=Math.max(answer, sum);
        }
        else{
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }
    DFS(0, 0);
    return answer;
}

let arr=[81, 58, 42, 33, 61];
console.log(solutionRef(259, arr));