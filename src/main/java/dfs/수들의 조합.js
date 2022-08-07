/*
수들의 조합
N개의 정수가 주어지면 그 숫자들 중 K개를 뽑는 조합의 합이 임의의 정수 M의 배수인 개수
는 몇 개가 있는지 출력하는 프로그램을 작성하세요.
예를 들면 5개의 숫자 2 4 5 8 12가 주어지고, 3개를 뽑은 조합의 합이 6의 배수인 조합을
찾으면 4+8+12 2+4+12로 2가지가 있습니다.
▣ 입력설명
첫줄에 정수의 개수 N(3<=N<=20)과 임의의 정수 K(2<=K<=N)가 주어지고,
두 번째 줄에는 N개의 정수가 주어진다.
세 번째 줄에 M이 주어집니다.
▣ 출력설명
총 가지수를 출력합니다.
▣ 입력예제 1
5 3
2 4 5 8 12
6
▣ 출력예제 1
2
 */

function solution(n, k, array, m){

    let resultArray = Array.from({length: k}, () => 0);
    let answer = [];
    function dfs(level, startIndex, sum){

        if (level === k) {
            if (sum % m === 0) {
                console.log(resultArray);
                answer.push(resultArray.slice());
            }
            return;
        }

        for (let i = startIndex; i < n; i++) {

            resultArray[level] = array[i];
            dfs(level + 1, i + 1, sum + array[i]);
        }
    }

    dfs(0, 0, 0);
    return answer;
}

console.log(solution(5, 3, [2, 4, 5, 8, 12], 6));
/*
N =5 개 중에서 K = 3 개를 뽑는 조합의 합을 6으로 나눈 나머지가 0인 경우는 4 8 12, 2 4 12로 2가지가 있습니다. if (level == k)가 되면 해당 조합의 경우에 대한 합을 6으로 나누고 나머지가 0인 경우 count를 증가시킵니다. d(level, startIndex, sum)에서 0번 인덱스 2를 선택한 경우 dfs(0 + 1, 0 + 1, 0 + 2) 그 다음 요소로 4 5 8 12를 선택할 수 있습니다. 1번 인덱스 4를 선택한 경우 dfs(1 + 1, 1 + 1, 2 + 4) = dfs(2, 2, 6)이고 5 8 12를 선택할 수 있습니다. 5 8 12 각각의 경우를 선택할 경우 3개를 뽑았으므로 level == 3이고 6의 배수인지 체크한 후 다시 level == 1로 돌아갑니다. i = 2, 5를 선택한 경우 dfs(1+1, 1 + 1, 2 +5) = dfs(2, 2, 7)이고  level == 2, startIndex ==2로 for(i = start; i < n; i++) 반복문을 수행합니다.  이때 5는 이미 선택했으니 제외하고 8, 12중에서 선택할 수 있습니다.
 */


function solutionBefore(n, k, array, m){
    let resultArray = Array.from({length: k}, () => 0);
    let answer = [];
    function dfs(level, startIndex){

        if (level === k) {
            let sum = 0;
            for (let i = 0; i < k; i++) {
                sum += resultArray[i];
            }
            if(sum % m === 0)
                answer.push(resultArray.slice());
            return;
        }

        for (let i = startIndex; i < n; i++) {
            resultArray[level] = array[i];
            dfs(level + 1, i + 1);
        }
    }

    dfs(0, 0);
    return answer;
}

// console.log(solutionBefore(5, 3, [2, 4, 5, 8, 12], 6));

/*
5개 숫자 중 3개를 뽑은 조합의 경우의 수를 구하고 각 경우의 수에 대해 6으로 나누었을 때 나머지가 0인 경우를 구하면 4 8 12, 2 4 12 로 2가지가 있습니다. N = 5개중 K = 3개를 뽑을 때 M = 6의 배수인 개수를 구해야합니다. 경우의 수를 구할때 resultArray[0] = array[1] = 4 를 선택한 경우 다음에 나올 수 있는 경우의 수는 dfs(Level, startIndex) = dfs(0 + 1, 1 + 1)  = dfs(1, 2) 입니다. for (let i = startIndex; i < k; i++) resultArray[level] = array[i] ; dfs(level + 1, startIndex + 1); if(level == k)일때 k개의 수를 다 뽑았으므로 sum에 각 resultArray[i] 요소를 더한 후 m으로 나눠서 나머지가 0인 경우 answer 배열에 담습니다. answer.push(resultArray.slice());
 */

function solutionRef(n, k, arr, m){
    let answer=0;
    function DFS(L, s, sum){
        if(L===k){
            if(sum%m===0) answer++;
        }
        else{
            for(let i=s; i<n; i++){
                DFS(L+1, i+1, sum+arr[i]);
            }
        }
    }

    DFS(0, 0, 0);
    return answer;
}

let arr=[2, 4, 5, 8, 12];
// console.log(solutionRef(5, 3, arr, 6));

/*
인덱스 0 ~ 4 중에서 하나를 선택하고 0을 선택한 경우 그 다음 레벨에서는 1,2,3,4 중에 하나를 선택합니다. 1을 선택한 경우 그 다음에는 2 3 4 중에서 선택가능합니다. 인덱스를 선택할 때 해당 인덱스에 들어있는 값을 sum에 더해서 구합니다. dfs(level, start, sum)에서 다음 레벨을 구할때는 dfs(level +1, i + 1, sum + array[i]가 됩니다.
 */