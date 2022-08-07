/*
부분집합 구하기(DFS)
자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
을 작성하세요.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
▣ 출력설명
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
단 공집합은 출력하지 않습니다.
▣ 입력예제 1
3
▣ 출력예제 1
1 2 3
1 2
1 3
1
2 3
2
3

 */

function solution(n){

    let check = Array.from(n+1, () => 0);

    function dfs(v){

        if(v=== n + 1) {
            // let answer = "";
            let answer = [];
            for (let i = 1; i <= n ; i++) {
                if (check[i] === 1) {

                    answer.push(i);
                    // answer += i + " ";
                }
            }
            if(answer.length > 0)
                console.log(answer);

            return;
        }
        check[v] = 1
        dfs(v + 1);
        check[v] = 0
        dfs(v + 1);
    }

    dfs(1);
}

solution(3);


/*
n = 3일 때를 예로 들면 { 1, 2, 3 } 중에서 1 있거나 없는 경우, 2가 있거나 없는 경우, 3이 있거나 없는 경우들을 조합한 것이 부분집합이 됩니다.
1 : o, x 인 경우 1 : o 일 때 2가 o , x인 경우 , 2 : o 일때 3 : o, x인 경우 등 여러 경우의 수가 o,x 2가지 경우로 곱해집니다.
1,2,3이 모두 있는 경우 : 111 / 1,2만 있는 경우 : 110 / 1,3만 있는 경우 : 101 / 1만 있는 경우 : 001 등
n = 3을 예로 들면 dfs(4) dfs(n+1)이 됐을 때 더 이상 존재하지 않으므로 return (종료) 시킵니다.
 */

function solutionBefore(n){


    let max = 1;
    for (let i = 0; i < n; i++) {
        max *= 2;
    }
    max -= 1;
    let array = new Array(n);
    let index = 0;
    function dfs(n) {
        if (n === 0) {

            return;
        }
        dfs(Math.floor(n / 2));
        //console.log(index + " : " + (n % 2));
        array[index] = n % 2;
        index++;
    }

    for (let i = max; i >=1; i--) {
        //console.log(i);
        array = new Array(n);
        index = 0;
        dfs(i);
        while(array[n - 1] == null) {

            // j-1 요소부터 0요소까지 오른쪽으로 하나씩 이동
            for (let j = n-2; j >= 0 ; j--) {
                array[j+1] = array[j]
            }
            array[0] = 0;

        }
        //console.log(array);
        let result = "";
        for (let j = 0; j < n; j++) {
            if (array[j] == 1) {
                result += ((j+1) + " ");
            }
        }
        console.log(result);
    }

}

// solution(3);

/*
입력예제 3이 주어졌을 때를 먼저 생각하면 1~3 | 1~2 | 1,3 | 1 | 2~3 | 2 | 3 순으로 출력합니다. 1, 2, 3의 부분 집합을 구한다고 할 때 1이 없거나 1이 있는 경우의 수는 2가지.
2가 없거나 2가 있는 경우의 수 2, 3이 없거나 3이 있는 경우의 수는 2입니다. 그래서 총 2^3 = 8개의 부분집합이 생기는데 공집합은 출력하지 않으므로 7개의 부분집합이 나옵니다.
1,2,3이 있고 없고를 비트로 표현할 경우 출력순서는 이진수로 봤을 때 111, 110, 101, 100, 011, 010, 001 입니다. 3비트로 나올 수 있는 값을 역순으로 구합니다.
n = 4일 경우 1111, 1110, 1101, 1100, 1011, 1010, 1001, 1000, 0111, 0110, 0101, 0100, 0011, 0010, 0001 총 15가지입니다.
우선 n=3일 때 111(2^3 - 1 = 7), 110 (2^3 - 2 = 6), 101 등 이진수로 값을 출력하는 것을 먼저 구합니다.
그 뒤 0,1 여부에 따라 index = 0일때 1 index = 1일때 2, index = 3 일때 3 등을 출력합니다.
n=3일때 길이가 3인 배열에 나머지 111일 경우 1 2 3 (i+1, i+2, i+3), 110일 경우 1 2 등으로 출력합니다.
dfs(3) 일때 dfs(1) array[index : 2] = 3 % 2 = 1, dfs(1)일때 dfs(0) array[index : 1] = 1 % 2 = 1, dfs(0)일때 return. array[0] = 1, array[index : 1] = 1 순차적으로 실행 및 return
배열의 가장 끝 요소가 비어있을 경우 예를 들어 값이 3인 경우 2번째 요소는 3번째로 , 1번째 요소는 2번째로 이동하고 1번째 요소는 0으로 채웁니다. 값이 1인 경우 1 null null 입니다. 우선 1 1 null로 이동하고 첫번째 요소는 0을 넣어줍니다. 0 1 null이 됩니다.
여전히 가장 끝 요소가 비어있으므로 0 0 1로 이동하고 첫번째 요소는 0을 넣어줍니다(어차피 0입니다).  while(array[n - 1] == null)로 구현합니다.
110, 011 등 배열 정보를 이용하여 요청한대로 값을 출력합니다다

 */


function solutionRef(n){
    let answer=[];
    let ch=Array.from({length:n+1}, ()=>0);
    function DFS(L){
        if(L===n+1){
            let tmp="";
            for(let i=1; i<=n; i++){
                if(ch[i]===1) tmp+=(i+" ");
            }
            if(tmp.length>0) answer.push(tmp.trim());
        }
        else{
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L+1);
        }
    }
    DFS(1);
    return answer;
}

// console.log(solutionRef(3));

function solutionCourse(n){

    let answer =[];
    // 길이 n+1인 배열을 만들고 0으로 초기화합니다.
    let ch = Array.from({length:n+1}, ()=>0)
    function DFS(v){
        if (v === n + 1) {
            let tmp = "";
            for (let i = 1; i <= n; i++) {
                if(ch[i] === 1)
                    tmp+= i+" ";
            }
            // console.log(tmp);
            if(tmp.length > 0)
                answer.push(tmp.trim());
            return;
        }
        /*
        ch[v] = 1은 집합에 포함시키는 것을 의미합니다.
         */
        ch[v] = 1;
        DFS(v + 1);
        ch[v] = 0;
        DFS(v + 1);
    }

    DFS(1)
    return answer;
}

console.log(solutionCourse(3));