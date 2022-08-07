/*
합이 같은 부분집합(DFS : 아마존 인터뷰)
N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면
”NO"를 출력하는 프로그램을 작성하세요.
둘로 나뉘는 두 부분집합은 서로소 집합(Disjoint Set)이며, 두 부분집합을 합하면 입력으로 주
어진 원래의 집합이 되어야 합니다.
예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이
16으로 같은 경우가 존재하는 것을 알 수 있다.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어집니다. 각 원소는 중복되지 않으며, 그 크기는 1,000,000
이하입니다.
▣ 출력설명
첫 번째 줄에 “YES" 또는 ”NO"를 출력합니다.
▣ 입력예제 1
6
1 3 5 6 7 10
▣ 출력예제 1
YES
 */

function solution(n, array){

    let totalSum = array.reduce((a, b) => (a + b), 0);
    // console.log("totalSum : " + totalSum);
    let answer = "NO";
    let flag = false;

    function dfs(l, sum) {
        if(flag)
            return;
        if (l > n - 1) {

            let sameCheck = totalSum - sum;
            if (sameCheck === sum) {
                answer = "YES";
                flag = true;
                console.log("check : " + sum);
            }
            return;
        }
        dfs(l + 1, sum + array[l]);
        dfs(l + 1, sum);
    }

    dfs(0, 0);
    return answer;
}

console.log(solution(6, [1, 3, 5, 6, 7, 10]));

/*
dfs(0), dfs(1), dfs(2) 등을 호출하다 부분집합의 원소의 합이 같은 경우가 나오면 뒤에 부분집합 경우의 수가 더 있더라도 체크하지 않고 함수를 종료합니다. flag를 통해 이를 구현합니다.
 */

function solutionBefore(n, array){


    // for (let i = 1; i<=n; i++) {
    //     check[i] = 1;
    //     console.log(check[i]);
    // }
    // console.log("test");
    // console.log(check);
    let check = Array.from(n + 1, () => 0);
    let result = "NO";
    function dfs(v){

        if (v > n) {
            let checkTrueSum = 0;
            let checkFalseSum = 0;
            for (let i = 1; i <= n; i++) {
                if (check[i]) {
                    checkTrueSum += parseInt(array[i - 1]);
                } else {
                    checkFalseSum += parseInt(array[i - 1]);
                }
            }
            if(checkTrueSum === checkFalseSum)
                result = "YES";
            console.log(check);
            console.log(checkTrueSum + " : " + checkFalseSum);
            return;
        }
        check[v] = 1;
        dfs(v + 1);
        check[v] = 0;
        dfs(v + 1);
    }

    dfs(1);
    return result;
}

// console.log(solutionBefore(6, ['1', '3', '5', '6', '7','10']));
// console.log(solutionBefore(6, ['1', '3', '5', '6', '7','10']));

/*

서로소(coprime)는 공약수가 1뿐인 두 정수나, 공약수가 0이 아닌 상수뿐인 두 다항식이나, 환 전체를 생성하는 두 아이디얼의 관계이다.
서로소(disjoint)는 공통으로 포함하는 원소가 없는 두 집합의 관계다.
{1,3,5,6,7,10} 6개의 원소가 있을때 둘로 나뉘는 서로소 집합 중에서 원소의 합이 서로 같은 경우가 있는지 탐색합니다.
서로소 집합은 {1}, {3,5,6,7,10} / {3}, {1,5,6,7,10} / {1,3}, {5,6,7,10} 등으로 나눌 수 있습니다.
1,3을 선택한경우 나머지 5,6,7,10의 합을 구한다음 비교하고 1,3,5를 선택한경우 나머지 6,7,10의 합을 구한다음 비교합니다.
1 3 5 6 7 10, 1 3 5 6 7 / 10, 1 3 5 7 10 / 6, 1 3 5 7 / 6 10 등 부분집합을 구하고 해당 부분집합의 나머지도 집합으로 보고 각 부분집합의 원소의 합을 구한다음 비교합니다.
• 각 원소들의 포함여부를 체크할 배열 check를 만들고 관리합니다.
• 방문할 경우 포함할 경우 check[i] = 1, 포함하지 않을 경우 0으로 값을 넣습니다. n개 예시로는 6개를 넘어서 방문하려할 경우 함수를 종료시킵니다. if(v == n+1) return;
방문이 끝났을 때 check 배열의 값을 참조하여 각 부분집합 원소들의 합을 구하고 비교한 뒤 존재할 경우 YES를 출력하고 아닐 경우 NO를 출력합니다
n개의 원소가 있다고 할 때 dfs(1)부터 시작할 경우 우선 1을 포함하는 경우부터 구합니다. check[1] = 1; dfs(n+1); check[1] = 0; dfs(n+1);
 */


function solutionRef(arr){
    let answer="NO", flag=0;
    let total=arr.reduce((a, b)=>a+b, 0);
    console.log(total);
    let n=arr.length;
    function DFS(L, sum){
        if(flag) return;
        if(L===n){
            if((total-sum)===sum){
                answer="YES";
                flag=1;
            }
        }
        else{
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }
    DFS(0, 0);
    return answer;
}

let arr=[1, 3, 5, 6, 7, 10];
// console.log(solutionRef(arr));