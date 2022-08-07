/*
미로탐색(DFS)
7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요. 출발점은 격
자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다. 격
자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
S 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 도착
위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.

▣ 입력설명
7*7 격자판의 정보가 주어집니다.
▣ 출력설명
첫 번째 줄에 경로의 가지수를 출력한다.
▣ 입력예제 1
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
▣ 출력예제 1
8
 */

function solution(board){
    let length = board.length -1;
    let check = Array.from({length: board.length}, () => new Array(board.length).fill(false));
    let directX = [0, 1, 0, -1];
    let directY = [-1, 0, 1, 0];
    let count = 0;
    let answer = [];
    let result = [];
    function dfs(x, y){

        if (x == length && y == length) {
            count++;
            answer.push(result.slice());
        }

        for (let i = 0; i < 4; i++) {
            let nextX = x + directX[i];
            let nextY = y + directY[i];

            if (0 <= nextX && nextX <= length && 0 <= nextY && nextY <= length && board[nextX][nextY] == 0 && !check[nextX][nextY]) {
                check[nextX][nextY] = true;
                result.push(nextX + " : " + nextY);
                dfs(nextX, nextY);
                check[nextX][nextY] = false;
                result.pop();
            }
        }

    }

    check[0][0] = true;
    dfs(0, 0);
    console.log("count : " + count);
    return answer;
}

/*
board[x][y]가 있을때 x>=0, y>=0 , x<=7, y<=7 조건을 만족하는 범위내에서 board[x][y] = 0인 경우 이동할 수 있습니다. 상하좌우로 이동할 수 있으므로 12시 3시 6시 9시 방향을 이동 가능하므로 (x, y-1), (x+1, y), (x, y+1), (x-1, y)로 이동 가능합니다. 이를 조건식으로 나타낼 경우 let directionX = [0, 1, 0, -1], let directionY = [-1, 0, 1, 0 ]
for(i = 0; i <4; i++) {
	let nextX = x + directionX[i];
	let nextY = y + directionY[i];
	if ( 0 <= nextX && nextX <=6 && 0<=nextY && nextY <=6 && board[nextX][nextY] == 0) {
	    check[nextX][nextY] = true;
		dfs(nextX, nextY)
		check[nextX][nextY] = false;
	}
}
 */

let array=[[0, 0, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 1, 1, 0],
    [0, 0, 0, 1, 0, 0, 0],
    [1, 1, 0, 1, 0, 1, 1],
    [1, 1, 0, 0, 0, 0, 1],
    [1, 1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 0, 0, 0]];

console.log(solution(array));

function solutionBefore(array){
    const length = array.length;
    let graph = Array.from({length: length+1}, ()=>new Array(length+1));
    let check = Array.from({length: length + 1}, () => new Array(length + 1).fill(false));
    let directionX = [0, 0, -1, 1]; //상하좌우 이동 시 좌표 이동
    let directionY = [1, -1, 0, 0];
    for (let i = 1; i <= array.length; i++) {
        for (let j = 1; j <= length; j++) {
            graph[i][j] = array[i - 1][j - 1];
        }
    }
    let count = 0;
    let answer = [];
    let result = [];
    function dfs(x,y){

        if(x <1 || y < 1)
            return;

        // console.log(x, y);
        // console.log("graph : " + graph[x][y]);
        if(graph[x][y])
            return;

        if (x === 7 && y === 7) {
            count++;
            answer.push(result.slice());
            return;
        }



        for (let i = 0; i < 4; i++) {
            let nextX = x + directionX[i] ;
            let nextY = y + directionY[i] ;
            if (nextX < 1 || nextY < 1 ||nextX > 7 || nextY > 7) {
                continue;
            }
            // console.log(i + " : (" + nextX + "," + nextY + ")");
            // console.log(check[nextX][nextY]);
            if(check[nextX][nextY])
                continue;
            check[nextX][nextY] = true;
            let point = nextX + " : " + nextY;
            result.push(point);
            dfs(nextX, nextY);
            check[nextX][nextY] = false;
            result.pop();
        }

    }
    check[1][1] = true;
    dfs(1, 1);
    // console.log("count : " + count);
    return answer;
}

// console.log(solutionBefore([[0, 0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1, 0], [0, 0, 0, 1, 0, 0, 0], [1, 1, 0, 1, 0, 1, 1], [1, 1, 0, 0, 0, 0, 1], [1, 1, 0, 1, 1, 0, 0], [1, 0, 0, 0, 0, 0, 0]]));

/*
(1,1)에서 출발해서 (7,7)로 갈 수 있는 경로는 8가지입니다. 상하좌우로만 이동할 수 있으며 다음에 갈 수 있는 좌표는 값이 0이어야 합니다. 상하좌우 4가지 경우중에서 값이 0인 좌표가 있으면 해당 좌표를 체크하고 그쪽으로 이동합니다. 좌표 x,y에서 x,y 모두 7이하인 경우만 확인하고 7을 넘어가거나 (7,7)에 도착한 경우 종료합니다. 위로 가는 경우 좌표는 (x, y+1), 아래로 가는 경우는 (x, y-1), 왼쪽으로 가는 경우 (x-1, y), 오른쪽으로 가는 경우 (x+1,y) 총 4가지 경우를 확인하고 갈 수 있으면 체크한 뒤 방문해야합니다.
 */


function solutionRef(board){
    let answer=0;
    let dx=[-1, 0, 1, 0];
    let dy=[0, 1, 0, -1];
    function DFS(x, y){
        if(x===6 && y===6) answer++;
        else{
            for(let k=0; k<4; k++){
                let nx=x+dx[k];
                let ny=y+dy[k];
                if(nx>=0 && nx<=6 && ny>=0 && ny<=6 && board[nx][ny]===0){
                    board[nx][ny]=1;
                    DFS(nx, ny);
                    board[nx][ny]=0;
                }
            }
        }
    }
    board[0][0]=1;
    DFS(0, 0);
    return answer;
}

let arr=[[0, 0, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 1, 1, 0],
    [0, 0, 0, 1, 0, 0, 0],
    [1, 1, 0, 1, 0, 1, 1],
    [1, 1, 0, 0, 0, 0, 1],
    [1, 1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 0, 0, 0]];

// console.log(solutionRef(arr));

/*
# 강의
12시 3시 6시 9시 방향중에서 갈 수 있는 곳을 체크합니다.
count를 하고 뒤로 되돌아가는 순간(백할때) 체크를 해제합니다
 */
