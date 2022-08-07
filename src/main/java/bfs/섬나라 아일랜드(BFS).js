/*
섬나라 아일랜드(BFS 활용)
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

function solution(){
    
}

let graph =[ [1, 1, 0, 0, 0, 1, 0]
    ,[0, 1, 1, 0, 1, 1, 0]
    ,[0, 1, 0, 0, 0, 0, 0]
    ,[0, 0, 0, 1, 0, 1, 1]
    ,[1, 1, 0, 1, 1, 0, 0]
    ,[1, 0, 0, 0, 1, 0, 0]
    ,[1, 0, 1, 0, 1, 0, 0] ];

 console.log(solution(7, graph));


function solutionBefore(n, graph){

    let check = Array.from({length: n}, () => new Array(n).fill(false));
    let directionX = [0, 1, 1, 1, 0, -1, -1, -1];
    let directionY = [1, 1, 0, -1, -1, -1, 0, 1];
    let queue = [];
    let count = 0;

    for (let x = 0; x < n; x++) {
        for (let y = 0; y < n; y++) {
            if (!check[x][y] && graph[x][y] == 1) {
                count++;
                // console.log("for : "  + x + " : " + y);
                bfs(x, y);
            }
        }
    }

    function bfs(x, y){
        check[x][y] = true;
        queue.push([x, y]);
        while (queue.length) {
            let position = queue.shift();
            // console.log(position);
            for (let i = 0; i < 8; i++) {
                let nextX = position[0] + directionX[i];
                let nextY = position[1] + directionY[i];
                if (0 <= nextX && nextX <= n - 1 && 0 <= nextY && nextY <= n - 1 && !check[nextX][nextY] && graph[nextX][nextY] == 1) {
                    // console.log("next | " + [nextX, nextY]);

                    check[nextX][nextY] = true;
                    queue.push([nextX, nextY]);
                }
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

// console.log(solutionBefore(7, graph));

/*
섬의 개수는 1로 표시된 값들이 연결된 그룹들을 구하는 것입니다. 상하좌우대각선으로 인접한 정점이 있는지 탐색하고 있으면 방문합니다. 방문한 정점을 체크하고 큐에 넣습니다. 주변에 더이상 방문할 정점이 없으면 종료합니다. for문을 통해 각 정점들에 대해 방문하지 않은 경우 count 개수를 증가시키고 check 또는 graph[x][y] = 0 으로 값을 변경하며 해당 위치를 방문합니다.
 */


function solutionRef(board){
    let answer=0;
    let n=board.length;
    let dx=[-1, -1, 0, 1, 1, 1, 0, -1];
    let dy=[0, 1, 1, 1, 0, -1, -1, -1];
    let queue=[];
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            if(board[i][j]===1){
                board[i][j]=0;
                queue.push([i, j]);
                answer++;
                while(queue.length){
                    let [x,y]=queue.shift();
                    for(let k=0; k<8; k++){
                        let nx=x+dx[k];
                        let ny=y+dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]===1){
                            board[nx][ny]=0;
                            queue.push([nx, ny]);
                        }
                    }
                }

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

console.log(solutionRef(arr));
