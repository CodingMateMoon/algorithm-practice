/*
순열 구하기
10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
니다.
▣ 입력설명
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
▣ 출력설명
첫 번째 줄에 결과를 출력합니다. 맨 마지막 총 경우의 수를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.
▣ 입력예제 1
3 2
3 6 9
▣ 출력예제 1
3 6
3 9
6 3
6 9
9 3
9 6
6
 */

function solution(n, m, array){

    let answer = [];
    let check = Array.from({length: n}, () => false);
    let resultArray = Array.from({length: m}, () => 0);
    function dfs(L){
        if (L === m) {

            answer.push(resultArray.slice());
            return;
        }

        for (let i = 0; i < n; i++) {
            if(check[i])
                continue;
            resultArray[L] = array[i];
            check[i] = true;
            dfs(L + 1);
            check[i] = false;
        }
    }
    dfs(0)
    console.log(answer.length);
    return answer;
}
console.log(solution(3, 2, [3, 6, 9]));

/*
3 6 9 중에 2개를 뽑아서 나열하는 방법은 3x2 = 6입니다. 첫번째 원소에서 인덱스 0을 선택할 경우 두번째 원소에서는 인덱스 0을 제외한 나머지 인덱스들을 선택해야하므로 check를 통해 사용한 인덱스를 제외하는 것이 필요합니다. if(L=== m) return; for문을 통해 인덱스 0, 1, 2 각각을 선택했을 때 경우의 수를 구합니다. resultArray[L] = array[i] Level에 따라 결과값 배열에 선택한 인덱스를 넣어줍니다.
* */

function solutionBefore(n, m , array){

    let check = Array.from({length: n}, () => false);
    let resultArray = Array.from({length:n}, ()=> 0);
    let count = 0;
    function dfs(L){

        if (L === m) {

            let result = "";
            for (let i = 0; i < m; i++) {
                result += resultArray[i] + " ";
            }
            console.log(result);
            count++;
            return;
        }

        for (let i = 0; i < n; i++) {
            //console.log(L + " : " + i + " : " + check[i]);

            if(check[i])
                continue;
            resultArray[L] = array[i];
            check[i] = true;
            dfs(L + 1);
            check[i] = false;
            resultArray[L] = 0;
        }
    }

    dfs(0);
    return count;
}

// console.log(solutionBefore(3, 2, [3, 6, 9]));


function solutionRef(m, arr){
    let answer=[];
    n=arr.length;
    let ch=Array.from({length:n}, ()=>0);
    let tmp=Array.from({length:m}, ()=>0);;
    function DFS(L){
        if(L===m){
            answer.push(tmp.slice());
        }
        else{
            for(let i=0; i<n; i++){
                if(ch[i]===0){
                    ch[i]=1;
                    tmp[L]=arr[i];
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }
    DFS(0);
    return answer;
}

let arr=[3, 6, 9];
// console.log(solutionRef(2, arr));