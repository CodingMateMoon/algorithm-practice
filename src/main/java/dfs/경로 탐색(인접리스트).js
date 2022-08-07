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

function solution(n, array){

    let graph = Array.from({length: n + 1}, ()=>Array());
    let check = Array.from({length: n + 1}, () => false);

    for (let [v, x] of array) {
        graph[v].push(x);
    }
    let count = 0;
    let answer = [];
    let result = [];
    function dfs(v){
        if (v === n) {
            count++;
            answer.push(result.slice());
            return;
        }

        for (let x of graph[v]) {
            // console.log(v, x);
            if(check[x])
                continue;
            check[x] = true;
            result.push(x);
            dfs(x);
            check[x] = false;
            result.pop();
        }
    }

    check[1] = true;
    result.push(1);
    dfs(1);
    return answer;
}

console.log(solution(5, [[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 5], [3, 4], [4, 2], [4, 5]]));

/*
인접리스트는 연결된 정점에 대해서 리스트로 관리합니다. 정점 1과 연결된 정점 2, 3, 4가 graph[1][i] -> graph[1][0], graph[1][1], graph[1][2] 에 저장되고 정점 2와 연결된 정점 3, 5가 graph[2][i] -> graph[2][0], graph[2][1] 에 저장됩니다. for (let [v, x] of array) graph[v].push(x)로 정점v와 연결된 x를 입력해서 연결 정보를 관리합니다. graph[v]에 대해 graph[v].length 만큼 for문을 돌려서 방문 여부를 체크하고
방문합니다.  더이상 방문할 곳이 없거나 정점 n=5에 도착한 경우 종료합니다.
 */


function solutionRef(n, arr){
    let answer=0;
    let graph=Array.from(Array(n+1), ()=>Array());
    let ch=Array.from({length:n+1}, ()=>0);
    let path=[]
    for(let [a, b] of arr){
        graph[a].push(b);
    }
    function DFS(v){
        if(v===n){
            answer++;
            // console.log(path);
        }
        else{
            for(let nv of graph[v]){
                if(ch[nv]===0){
                    path.push(nv);
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                    path.pop();
                }
            }
        }
    }
    ch[1]=1;
    path.push(1);
    DFS(1);
    return answer;
}

let arr=[[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 5], [3, 4], [4, 2], [4, 5]];
// console.log(solutionRef(5, arr));

/*
정점 개수가 많을 경우 인접행렬로 구현시 메모리 낭비가 크고 시간복잡도도 높아집니다. 정점이 10000개라면 1번 정점과 연결된 정점이 5개밖에 없더라도 1만번 돌아야합니다. 따라서 이와 같은 상황에서는 인접리스트가 효율적입니다

 */