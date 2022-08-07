/*
두 배열 합치기
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램
을 작성하세요.
▣ 입력설명
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
▣ 출력설명
오름차순으로 정렬된 배열을 출력합니다.
▣ 입력예제 1
3
1 3 5
5
2 3 6 7 9
▣ 출력예제 1
1 2 3 3 5 6 7 9
 */
function solution(n, nArr, m, mArr) {
    let nIndex = 0;
    let mIndex = 0;
    let answer = [];
    while (nIndex < n && mIndex < m) {
        let input;
        if (nArr[nIndex] < mArr[mIndex]) {
            input = nArr[nIndex];
            nIndex++;
        } else {
            input = mArr[mIndex];
            mIndex++;
        }
        answer.push(input);
    }
    while (mIndex < m) {
        answer.push(mArr[mIndex]);
        mIndex++;
    }

    while (nIndex < n) {
        answer.push(nArr[nIndex]);
        nIndex++;
    }

    return answer;
}

console.log(solution(3, [1, 3, 5], 5, [2, 3, 6, 7, 9]));
console.log(solution(5, [1, 3, 4, 8, 11], 3, [2, 5, 9]));
/*
오름차순으로 정렬이 된 상태의 두 배열을 합치는 것으로 먼저 각 배열에 대해서는 정렬이 된 상태인 것을 활용할 수 있습니다. 두 배열 중에서 가장 첫번째 요소부터
하나씩 꺼내서 비교한 후 크기가 작은 것을 우선적으로 새로운 배열에 입력하는식으로 합칠 수 있습니다. 이때 nArr의 요소 i와 mArr 요소 j를 비교하고
nArr의 요소 i를 새로운 배열에 입력했을 경우, nArr의 i+1요소와 mArr의 j요소를 비교하는 작업이 필요합니다. nIndex가 길이 n의 마지막에 도달하거나 mIndex가 m에 도달할 경우 나머지 요소들을 새로운 배열에
모두 넣어줍니다.
입력예제1을 예시로 들면 n(nArr)의 1번째 요소(n[0]) 1은 m의 1번째 요소 2보다 작으므로 1이 새로운 배열에 먼저 들어가고(iIndex++) n의 2번째 요소 3보다 m의 1번째 요소 2가 더 작으므로 2가 들어갑니다(jIndex++).
 n의 2번째 요소 3과 m의 2번째 요소 3에서 n[1] < m[1]일 경우 m[1] 아닐 경우 n[1]이 들어가도록 기준을 정해서 n[1]이 먼저 들어가도록 하고 n[2] = 5, m[1] = 3이므로 m[1]이 들어갑니다.
 그다음 n[2] = 5가 들어가고 나머지 m[2] = 6 부터 m[3], m[4] 모두 값을 넣어줍니다.
 */