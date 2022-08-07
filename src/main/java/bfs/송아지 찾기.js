/*
송아지 찾기(BFS : 상태트리탐색)
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아
지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음
과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수
있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성
하세요.
▣ 입력설명
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000
까지이다.
▣ 출력설명
점프의 최소횟수를 구한다. 답은 1이상입니다.
▣ 입력예제 1
5 14
▣ 출력예제 1
3
▣ 입력예제 2
8 3
▣ 출력예제 2
5
 */

function solution(s, e){
    let answer = 0;
    let check = Array.from({length: 10001}, () => false);
    let moveCount = Array.from({length: 10001}, ()=> 0);
    let queue = [];
    check[s] = true;
    moveCount[s] = 0;
    queue.push(s);

    while (queue.length) {
        let x = queue.shift();
        for (let nextX of [x - 1, x + 1, x + 5]) {
            if (nextX === e) {
                return moveCount[x] + 1
            }
            if (1 <= nextX && nextX <= 10000 && !check[nextX]) {
                check[nextX] = true;
                moveCount[nextX] = moveCount[x] + 1;
                queue.push(nextX);
            }
        }
    }
    return answer;
}

console.log(solution(5, 14));
console.log(solution(8, 3));
/*
방문한 지점을 체크할 배열, 이동횟수를 저장할 배열을 만들고 관리합니다.
 */

function solutionBefore(s, e){

    let move = [-1, 1, 5];
    let queue = [];
    let count = 0;
    queue.push([0, s]);
    while (queue.length) {
        let location = queue.shift();

        for (let i = 0; i < 3; i++) {
            let nextLocation = location[1] + move[i];
            let nextLevel = location[0] + 1;
            // console.log(nextLevel, nextLocation);
            if (nextLocation === e) {
                return nextLevel;
            }
            queue.push([nextLevel, nextLocation]);
        }
    }
}

// console.log(solutionBefore(5,14));
// console.log(solutionBefore(8,3));

/*
현수의 위치가 S=5, 송아지의 위치가 E=14일 때 S-1,S+1, S+5로 이동 가능합니다. level =1 에서 5 -1 = 4 , 5+1 = 6 , 5+5 = 10 으로 이동 가능합니다. 다시 4일 때는 3 5 9 , 6일 때는 5 7 11, 10일 때는 9 11 15 등이 있고 5-> 4->9->14로 3번에 이동 가능합니다. 먼저 레벨과 위치 [level, location] 를 queue에 넣고 s-1, s+1, s+5 중에 e를 만족하는 게 있는지 확인하고 없는 경우 다시 queue에 넣습니다. let location = queue.shift(); for (let i = 0; i < 3; i++) {
let nextLevel = location[0] + 1; let nextLocation = location[1] + move[i];
 */

function solutionRef(s, e){
    let answer=0;
    let ch=Array.from({length:10001}, ()=>0);
    let dis=Array.from({length:10001}, ()=>0);
    let queue=[];
    queue.push(s);
    ch[s]=1;
    dis[s]=0;
    while(queue.length){
        let x=queue.shift();
        for(let nx of [x-1, x+1, x+5]){
            if(nx===e) return dis[x]+1;
            if(nx>0 && nx<=10000 && ch[nx]===0){
                ch[nx]=1;
                queue.push(nx);
                dis[nx]=dis[x]+1;
            }
        }
    }
    return answer;
}

// console.log(solutionRef(8, 3));
/*
queue에 5를 넣고 5 다음에 갈 수 있는 지점들을 확인하고 도착지점이 아니라면 큐에 넣습니다. check배열을 만들어서 이미 간 곳은 체크한 뒤 다시 큐에 넣지 않도록 합니다. 1부터 10000까지 좌표를 벗어나면 안됩니다.  x 지점에서 한번만에 갈 수 있는 것들은 다 큐에 넣습니다
 */