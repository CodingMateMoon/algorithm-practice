/*
아래 그림과 같은 이진트리를 넓이우선탐색해 보세요.
        1
      2     3
    4  5  6  7
 */

function solutionRef() {
    let answer = "";
    let queue = [];
    queue.push(1);
    while(queue.length) {
        let v = queue.shift();
        answer += v + " ";
        for(let nv of [v * 2, v *2 + 1] ) {
            // console.log(v, nv);
            if(nv > 7) continue;
            queue.push(nv);
        }
    }

    return answer;
}

console.log(solutionRef());
/*
넓이우선탐색은 상태트리를 레벨 탐색합니다. 그리고 최단거리를 구하는 방법론입니다. 출발지점에서 간선 1번만에 갈 수 있는 것중에 도착 지점이 있는지 최단거리를 탐색합니다. 탐색해보고 없으면 나옵니다. 출발지점 1 에서 한번만에 갈 수 있는 것들중에는 도착지점이 없습니다. 두번만에 갈 수 있는 2로 가고 다음에 갈 수 있는 정점들은 4,5가 있습니다. 4로 두 번만에 2레벨 지점에 갈 수 있습니다.
 */