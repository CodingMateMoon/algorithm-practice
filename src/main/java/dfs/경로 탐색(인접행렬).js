/*
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5
총 6 가지입니다.

▣ 입력설명
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
결정보가 주어진다.
▣ 출력설명
총 가지수를 출력한다.
▣ 입력예제 1
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
▣ 출력예제 1
6

 */

function solution(n, m, array){

    // Array 내부의 값을 Array.fill(0)으로 채우지 않을 경우 에러 발생 : Cannot set properties of undefined (setting 'undefined')
    // let graph = Array.from({length: n + 1}, ()=>new Array(n + 1));
    let graph = Array.from({length: n + 1}, ()=>new Array(n + 1).fill(0));
    let check = Array.from({length: n + 1}, () => false);

    for (let [a, b] of array) {
        graph[a][b] = 1;
    }
    let result = [];
    let answer = [];
    let count = 0;

    function dfs(v){
        if (v === n) {
            // console.log(result);
            answer.push(result.slice());
            count++;
            return;
        }

        for (let i = 1; i <= n ; i++) {
            if(check[i])
                continue;
            if (graph[v][i]) {
                // console.log(v, i);
                check[i] = true;
                result.push(i);
                dfs(i)
                check[i] = false;
                result.pop();
            }

        }
    }
    check[1] = true;
    result.push(1);
    dfs(1);
    console.log("count : " + count);
    return answer;
}

/*
1번 정점부터 시작해서 갈 수 있는 경우를 구할 때 1~5 중에서 이미 방문한 1은 체크하고 2,3,4,5에서 간선 연결 정보가 있는 정점으로 이동합니다. 1에서 2, 3, 4로 이동할 수 있는데 먼저 2를 방문합니다. 1-2- 다음에 갈 수 있는 정점은 1은 이미 체크되었고 3, 5가 있습니다. 3을 선택할 경우 4 , 4를 선택할 경우 5를 방문하고 5를 방문한 경우 count를 증가시키며 다시 5->4->3->2 로 돌아갑니다. 이떄 체크했던 정점에 대해 다시 check[v][i] = false로 해제시킵니다. 1-2-5를 방문하고 count를 증가시킵니다.
dfs(v)라고 할 때 dfs(1)에서 시작해서 2로 갈 경우 check[v][i] = check[1][2] = true;
 */

console.log(solution(5, 9, [[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 5], [3, 4], [4, 2], [4, 5]]));

function solutionBefore(n, m, array){

    let matrix = Array.from({length: n + 1}, () => new Array(n + 1));
    let check = Array.from({length: n + 1});
    let resultArray = Array.from({length: n});
    resultArray[0] = 1;
    for (let i = 0; i < array.length; i++) {
        matrix[array[i][0]][array[i][1]] = true;
    }
    console.log("matrix");
    console.log(matrix);
    let count = 0;
    let answer = [];
    function dfs(level, currentIndex){
        if (level === n) {
            return;
        }
        for (let i = 2; i <= n ; i++) {
            if(check[i])
                continue;
            if (matrix[currentIndex][i]) {
                check[i] = true;
                resultArray[level] = i;
                if (i === n) {
                    count++;
                    answer.push(resultArray.slice());
                }
                dfs(level + 1, i);
                resultArray[level] = 0;
                check[i] = false;
            }
        }
    }

    dfs(1, 1);
    // console.log("count : " + count);
    return answer;
}

// console.log(solutionBefore(5, 9, [[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 5], [3, 4], [4, 2], [4, 5]]));
/*
# 정점의 수 N=5, 간선의 수 M = 9가 주어지고 M줄에 걸쳐 간선 연결정보 1 2, 1 3, 1 4, 2 1 등이 주어집니다. 1번 정점에서 N = 5 정점으로 가는 총 가지수 6을 출력합니다. 1번 노드에서 시작해서 갈 수 있는 경우의 수는 2, 3, 4가 있습니다. 2를 선택한 경우 3, 5 가 있고 3을 선택한 경우 4가 있으며 4를 선택할 경우 5로 이동해서 도착합니다. 다시 2를 선택한 경우로 돌아가서 5로 이동하고 더이상 탐색할 게 없으므로 1번 노드로 돌아가서 3을 선택합니다. 이후 4를 선택하고 2, 5 중에서 2를 선택한 뒤 5로 이동하고 4로 돌아가서 5를 선택합니다. 행렬 이차원 배열 array[i][j]에서 i = 1일 때 갈 수 있는 경우는 2, 3, 4가 있습니다. 2를 선택한 경우 1은 체크로 제외하고 3 5에 갈 수 있습니다. 3을 선택한 경우 4, 5 가 있고 4를 선택한 경우 5가 있습니다.  다시 4->3->2 로 돌아가서 5를 선택합니다.
dfs(level, currentIndex) = dfs(1, 1)
정점 1에서 시작하므로 level = 1, currentIndex = 1에서 시작해서 for(let i = 2; i <= n; i++) 1행중에서 갈 수 있는 경우를 구합니다. 먼저 2번에 갈 수 있으므로 if(matrix[currentIndex][i]) check[i] = true; resultArray[level] = i; dfs(level +1, i); 2번을 체크하고 2행으로 갑니다. dfs(level + 1, currentIndex)
 */


function solutionRef(n,arr) {

    let answer = 0;
    let graph = Array.from(Array(n+1), ()=> Array(n+1).fill(0));
    let ch  = Array.from({length:n+1}, ()=>0);
    path = [];
    for (let [a,b] of arr) {
        // console.log(a,b);
        graph[a][b] = 1; // 무방향일경우 [b][a] = 1;
    }
    function dfs(v) {
        if(v === n) {
            answer++;
            // console.log(path);
        }
        else {
            for(let i = 1; i <= n ; i++) {
                if(graph[v][i] === 1 && ch[i] === 0) {
                    ch[i] = 1;
                    path.push(i);
                    dfs(i);
                    ch[i] = 0;
                    path.pop();
                }
            }
        }
    }

    path.push(1);
    ch[1] = 1;
    dfs(1);
    return answer;
}

let arr = [[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 5], [3, 4], [4, 2], [4, 5]];
// console.log(solutionRef(5,arr));