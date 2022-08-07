/*
섬나라 아일랜드(DFS 활용)
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다. 각 섬은 1로 표시되어 상하좌
우와 대각선으로 연결되어 있으며, 0은 바다입니다. 섬나라 아일랜드에 몇 개의 섬이 있는지
구하는 프로그램을 작성하세요.
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
만약 위와 같다면
▣ 입력설명
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 격자판 정보가 주어진다.
▣ 출력설명
첫 번째 줄에 섬의 개수를 출력한다.
▣ 입력예제 1
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
▣ 출력예제 1
5
 */

function solution(n, graph){

    let directionX = [0, 1, 1, 1, 0, -1, -1, -1];
    let directionY = [-1, -1, 0, 1, 1, 1, 0, -1];
    let check = Array.from({length: n}, ()=>new Array(n));
    let count = 0;
    for (let x = 0; x < n; x++) {
        for (let y = 0; y < n; y++) {
            if (!check[x][y] && graph[x][y] == 1) {
                console.log(x, y);
                count++;

                check[x][y] = true;
                dfs(x, y);
            }
        }
    }

    function dfs(x, y){

        for (let i = 0; i < 8; i++) {
            let nextX = x + directionX[i];
            let nextY = y + directionY[i];
            if (0 <= nextX && nextX <= n - 1 && 0 <= nextY && nextY <= n - 1 && !check[nextX][nextY] && graph[nextX][nextY] == 1) {
                check[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }
    return count;
}

let graph =[ [1, 1, 0, 0, 0, 1, 0]
            ,[0, 1, 1, 0, 1, 1, 0]
            ,[0, 1, 0, 0, 0, 0, 0]
            ,[0, 0, 0, 1, 0, 1, 1]
            ,[1, 1, 0, 1, 1, 0, 0]
            ,[1, 0, 0, 0, 1, 0, 0]
            ,[1, 0, 1, 0, 1, 0, 0] ];

console.log(solution(7, graph));

/*
섬의 개수는 1로 표시된 값들이 연결된 그룹들을 구하는 것입니다. 반복문을 통해 해당 위치가 가진 값이 1인 경우 주변에 1이 있는지 탐색을 합니다. 이때 방문한 좌표는 check를 하고 더이상 탐색할 곳이 없으면 종료합니다. 각 표별로 방문하지 않았고 값이 1인 경우 탐색을 하고 count를 증가시킵니다.
- 방문 좌표 정보 저장 : let check = Array.from({length : n+1}, new Array(n+1).fill(false))
- graph [[1,1,0,0,0,1,0]
- 상하좌우 대각선 12시 1시 3시 4시 6시 7시 9시 10시 방문여부 확인 후 탐색 let directionX = [0, 1, 1, 1, 0, -1, -1, -1 ], let directionY = [-1, -1, 0, 1 , 1, 1, 0, -1]
- count : 방문하지 않은 정점. 섬의 개수 count

 */

function solutionRef(board){
    let answer=0;
    let n=board.length;
    let dx=[-1, -1, 0, 1, 1, 1, 0, -1];
    let dy=[0, 1, 1, 1, 0, -1, -1, -1];
    function DFS(x, y){
        board[x][y]=0;
        for(let k=0; k<8; k++){
            let nx=x+dx[k];
            let ny=y+dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]===1){
                DFS(nx, ny);
            }
        }
    }
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            if(board[i][j]===1){
                board[i][j]=0;
                // console.log(i, j);
                answer++;
                DFS(i, j);
            }
        }
    }
    return answer;
}

let arr=[[1, 1, 0, 0, 0, 1, 0],
    [0, 1, 1, 0, 1, 1, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 1, 1],
    [1, 1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 1, 0, 0],
    [1, 0, 1, 0, 1, 0, 0]];

// console.log(solutionRef(arr));


