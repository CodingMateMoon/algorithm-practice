/*
중복순열 구하기
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
하는 방법을 모두 출력합니다.
▣ 입력설명
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
▣ 출력설명
첫 번째 줄에 결과를 출력합니다. 맨 마지막 총 경우의 수를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.
▣ 입력예제 1
3 2
▣ 출력예제 1
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
9
 */


function solution(n, m){

    let answer = [];
    let resultArray = Array.from({length: m}, () => 0);
    function dfs(L) {

        if (L === m) {
            // console.log(resultArray);
            answer.push(resultArray.slice());
            return;
        }

        for (let i = 1; i <= n; i++) {
            resultArray[L] = i;
            // console.log(L + " : " + i);
            // console.log(resultArray);
            // console.log("-------------");
            dfs(L + 1);
        }
    }

    dfs(0);
    return answer;
}

console.log(solution(3, 3));


function solutionBefore(n, m){

    let answer = "";
    let resultArray = Array.from({length: m}, () => 0);
    function dfs(L) {

        if (L === m) {
            console.log(resultArray);
            return;
        }

        for (let i = 1; i <= n; i++) {
            resultArray[L] = i;
            // console.log(L + " : " + i);
            // console.log(resultArray);
            // console.log("-------------");
            dfs(L + 1);
        }
    }
    dfs(0)
}

// solutionBefore(3, 3);

/*
L = 0일때 temp[0] = i (1~ n), dfs(1)을 호출합니다. L = 1, temp[1] = i (1~n), dfs(3)을 호출합니다 L ===3 이므로 resultArray를 출력하고 종료시킵니다.
D(0) 부터 시작해서 1, 2, 3으로 뽑을 수 있습니다.
m값에 따라 m중 for문이 필요합니다. 동적으로 m을 받아서 출력하기 때문에 for문으로는 어렵고 재귀를 이용하여 m레벨까지 값을 출력합니다.
m = 3 일 경우 3레벨까지 저장할 임시 배열을 만들어줍니다. L = 0일때 resultArray에서 0 인덱스에 i를 입력하고 resultArray[0] = i; dfs(L+1); 을 호출합니다.
L = 1일 때 resultArray에서 1 인덱스에 j (1~n) 를 입력하고 resultArray[1] = j; dfs(L+1);을 호출합니다[D(2)].
L = 2일 때 resultArray에서 2 인덱스에 k (1~n) 를 입력하고 dfs(2+1); 을 호출합니다. d(3)일 때 if(L === 3) return; 으로 종료시킵니다.
 */


function solutionRef(n, m){
    let answer=[];
    let tmp=Array.from({length:m}, ()=>0);
    function DFS(L){
        if(L===m){
            answer.push(tmp.slice());
        }
        else{
            for(let i=1; i<=n; i++){
                tmp[L]=i;
                DFS(L+1);
            }
        }
    }

    DFS(0);
    return answer;
}

// console.log(solutionRef(3, 2));